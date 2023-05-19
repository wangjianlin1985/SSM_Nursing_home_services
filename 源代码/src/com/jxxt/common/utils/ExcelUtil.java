/**
 * ExcelUtil.java 2017年1月11日
 * 
 * Copyright 2001-2017 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jxxt.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.jxxt.common.annotation.Template;

/**
 * Excel解析工具
 * 
 * @author hqsun
 * @since 2017年1月11日
 *
 */
public final class ExcelUtil {

	/**
	 * 将Excel解析成指定对象
	 *
	 * @author hqsun
	 * @param inputStream
	 * @param clazz
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws ReflectiveOperationException
	 * @throws IOException
	 * @since 2017年1月11日
	 */
	public static <T> List<T> parse(InputStream inputStream, Class<T> clazz)
			throws EncryptedDocumentException, InvalidFormatException, ReflectiveOperationException, IOException {
		try {
			return parse(WorkbookFactory.create(inputStream), clazz);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}

	/**
	 * 将Excel解析成指定对象
	 *
	 * @author hqsun
	 * @param workbook
	 * @param clazz
	 * @return
	 * @throws ReflectiveOperationException
	 * @since 2017年1月11日
	 */
	public static <T> List<T> parse(Workbook workbook, Class<T> clazz) throws ReflectiveOperationException {

		Template sheetAnno = clazz.getAnnotation(Template.class);

		// 反射该页记录模型class，封装待处理对象
		Map<String, Doer> doerMap = new HashMap<>();
		fillDoerMap(doerMap, clazz);

		// 临时记录每列信息，备用于实例化
		Set<Doer> doerSet = null;
		// 临时记录每行信息，备用于实例化
		List<Set<Doer>> drList = null;

		// 根据注解名称找到对应的Sheet页签
		Sheet sheet = null;
		if (sheetAnno != null) {
			sheet = workbook.getSheet(sheetAnno.value());
		} else {
			sheet = workbook.getSheetAt(0);
		}

		if (sheet != null) {
			// 获取Sheet页签的总行数
			int rowSize = sheet.getPhysicalNumberOfRows();

			if (rowSize > 0) {
				drList = new ArrayList<>(rowSize - 1);
				Row row = null;
				int cellSize = 0;
				Cell cell = null;
				String cellVal = "";

				// 逐行处理表格内容
				for (int rownum = 0; rownum < rowSize; rownum++) {
					row = sheet.getRow(rownum);
					if (rownum == 0) {
						// 获取总列数
						cellSize = row.getPhysicalNumberOfCells();
					}
					if (null != row) {
						if (cellSize > 0) {
							Doer doer = null;

							// 逐列处理表格内容
							for (int cellnum = 0; cellnum < cellSize; cellnum++) {
								cellVal = "";
								cell = row.getCell(cellnum);
								if (cell != null) {
									// 第一行为文件标题行，需要解析的实际内容从第二行开始
									if (rownum == 0) {
										cell.setCellType(Cell.CELL_TYPE_STRING);
										cellVal = cell.getStringCellValue();
										cellVal = StringUtils.trimToEmpty(cellVal);

										// 记录标题行下标
										doer = doerMap.remove(cellVal);
										if (doer != null) {
											doerMap.put(String.valueOf(cellnum), doer);
										}
									} else {
										// 记录每列内容
										doer = doerMap.get(String.valueOf(cellnum));
										if (doer != null) {
											if (Cell.CELL_TYPE_NUMERIC == cell.getCellType() && StringUtils
													.equals("Date", doer.getFieldType().getSimpleName())) {
												Date dateVal = cell.getDateCellValue();
												if (dateVal != null) {
													cellVal = DateFormatter.formatDate(doer.getDateFormat(), dateVal);
												}
											} else {
												cell.setCellType(Cell.CELL_TYPE_STRING);
												cellVal = cell.getStringCellValue();
												cellVal = StringUtils.trimToEmpty(cellVal);
											}

											doer.setCellVal(cellVal);
										}
									}
								} else {
									doer = doerMap.get(String.valueOf(cellnum));
									if (doer != null) {
										doer.setCellVal(null);
									}
								}
							}

							// 临时记录行列信息，备用待实例化
							if (rownum > 0) {
								doerSet = new HashSet<>(doerMap.size());
								Doer newDoer = null;
								for (Doer mapVal : doerMap.values()) {
									newDoer = new Doer(mapVal);
									doerSet.add(newDoer);
								}
								drList.add(doerSet);
							}
						}
					}
				}
				// 实例化页记录模型
				if (CollectionUtils.isNotEmpty(drList)) {
					Set<Doer> set = null;
					List<T> lst = new ArrayList<>();

					for (int i = 0; i < drList.size(); i++) {
						set = drList.get(i);

						boolean flag = false;
						for (Doer d : set) {
							if (d.getFieldVal() != null && StringUtils.isNotBlank(String.valueOf(d.getFieldVal()))) {
								flag = true;
								break;
							}
						}

						if (flag) {
							T t = clazz.newInstance();

							for (Doer d : set) {
								clazz.getMethod(d.getSetter(), d.getFieldType()).invoke(t, d.getFieldVal());
							}
							clazz.getMethod("setRow", Long.class).invoke(t, Long.valueOf(i + 1L));

							lst.add(t);
						}
					}

					return lst;
				}
			}
		}

		return null;
	}

	private static void fillDoerMap(Map<String, Doer> doerMap, Class<?> clazz) {

		Field[] fields = clazz.getDeclaredFields();
		if (ArrayUtils.isNotEmpty(fields)) {
			Doer doer = null;
			Template cellAnno = null;
			for (Field field : fields) {
				cellAnno = field.getAnnotation(Template.class);
				if (cellAnno != null) {
					doer = new Doer();
					doer.setAnnoVal(cellAnno.value());
					doer.setDateFormat(cellAnno.dateFormate());
					doer.setFieldName(field.getName());
					doer.setFieldType(field.getType());
					doer.setSetter("set" + StringUtils.capitalize(field.getName()));

					doerMap.put(doer.getAnnoVal(), doer);
				}
			}
		}

		Class<?> superClazz = clazz.getSuperclass();
		if (!StringUtils.equals("Object", superClazz.getSimpleName())) {
			fillDoerMap(doerMap, superClazz);
		}
	}

	/**
	 * 私有构造
	 */
	private ExcelUtil() {
	}

}

/**
 * 待处理解析任务对象
 * 
 * @author hqsun
 * @since 2016年12月24日
 *
 */
class Doer {
	/**
	 * 默认构造
	 */
	public Doer() {
	}

	/**
	 * 构造方法复制克隆
	 * 
	 * @param d
	 */
	public Doer(Doer d) {
		this.annoVal = d.getAnnoVal();
		this.dateFormat = d.getDateFormat();
		this.fieldName = d.getFieldName();
		this.fieldType = d.getFieldType();
		this.setter = d.getSetter();
		this.cellVal = d.getCellVal();
	}

	/**
	 * 属性注解
	 */
	private String annoVal = "";

	/**
	 * 日期格式
	 */
	private String dateFormat = "";

	/**
	 * 属性名
	 */
	private String fieldName = "";

	/**
	 * 属性类型
	 */
	private Class<?> fieldType;

	/**
	 * set方法名
	 */
	private String setter = "";

	/**
	 * 表格字段值
	 */
	private String cellVal = "";

	/**
	 * Get the annoVal
	 * 
	 * @return annoVal
	 * @see PrepPackageAnalysis.Doer#annoVal
	 */
	public String getAnnoVal() {
		return annoVal;
	}

	/**
	 * Set the annoVal
	 * 
	 * @param annoVal
	 * @see PrepPackageAnalysis.Doer#annoVal
	 */
	public void setAnnoVal(String annoVal) {
		this.annoVal = annoVal;
	}

	/**
	 * Get the dateFormat
	 * 
	 * @return dateFormat
	 * @see Doer#dateFormat
	 */
	public String getDateFormat() {
		return dateFormat;
	}

	/**
	 * Set the dateFormat
	 * 
	 * @param dateFormat
	 * @see Doer#dateFormat
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * Get the fieldName
	 * 
	 * @return fieldName
	 * @see PrepPackageAnalysis.Doer#fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Set the fieldName
	 * 
	 * @param fieldName
	 * @see PrepPackageAnalysis.Doer#fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * Get the fieldType
	 * 
	 * @return fieldType
	 * @see PrepPackageAnalysis.Doer#fieldType
	 */
	public Class<?> getFieldType() {
		return fieldType;
	}

	/**
	 * Set the fieldType
	 * 
	 * @param fieldType
	 * @see PrepPackageAnalysis.Doer#fieldType
	 */
	public void setFieldType(Class<?> fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * Get the setter
	 * 
	 * @return setter
	 * @see PrepPackageAnalysis.Doer#setter
	 */
	public String getSetter() {
		return setter;
	}

	/**
	 * Set the setter
	 * 
	 * @param setter
	 * @see PrepPackageAnalysis.Doer#setter
	 */
	public void setSetter(String setter) {
		this.setter = setter;
	}

	/**
	 * Get the cellVal
	 * 
	 * @return cellVal
	 * @see PrepPackageAnalysis.Doer#cellVal
	 */
	public String getCellVal() {
		return cellVal;
	}

	/**
	 * Set the cellVal
	 * 
	 * @param cellVal
	 * @see PrepPackageAnalysis.Doer#cellVal
	 */
	public void setCellVal(String cellVal) {
		this.cellVal = cellVal;
	}

	/**
	 * Get the FieldVal
	 *
	 * @author hqsun
	 * @return
	 */
	public Object getFieldVal() {
		try {
			String simp = fieldType.getSimpleName();

			switch (simp) {
			case "int":
				return NumberUtils.toInt(cellVal);
			case "Integer":
				return StringUtils.isBlank(cellVal) ? null : Integer.valueOf(cellVal);
			case "long":
				return NumberUtils.toLong(cellVal);
			case "Long":
				return StringUtils.isBlank(cellVal) ? null : Long.valueOf(cellVal);
			case "Date":
				return StringUtils.isBlank(cellVal) ? null : DateFormatter.toDate(dateFormat, cellVal);
			case "double":
				return NumberUtils.toDouble(cellVal);
			case "Double":
				return StringUtils.isBlank(cellVal) ? null : Double.valueOf(cellVal);
			default:
				return cellVal;
			}
		} catch (Exception e) {
			throw new RuntimeException("Doer getFieldVal error. " + this, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Doer [annoVal=");
		builder.append(annoVal);
		builder.append(", dateFormat=");
		builder.append(dateFormat);
		builder.append(", fieldName=");
		builder.append(fieldName);
		builder.append(", fieldType=");
		builder.append(fieldType);
		builder.append(", setter=");
		builder.append(setter);
		builder.append(", cellVal=");
		builder.append(cellVal);
		builder.append("]");
		return builder.toString();
	}

}
