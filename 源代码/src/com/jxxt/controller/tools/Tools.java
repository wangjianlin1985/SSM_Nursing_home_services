package com.jxxt.controller.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

public class Tools {

	
	/*public static  void responseOutWithJson(HttpServletResponse response,  
	        Object responseObject) {  
	    //将实体对象转换为JSON Object转换  
	    JSONObject responseJSONObject = JSONObject.fromObject(responseObject);  
	    response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");  
	    PrintWriter out = null;  
	    try {  
	        out = response.getWriter();  
	        out.append(responseJSONObject.toString());  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (out != null) {  
	            out.close();  
	        }  
	    }  
	} */

	public String nowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		return sdf.format(new Date());
		
	}
	

	/**
	 * 将Object对象转化为JSON打印出来
	 * 
	 * @param object
	 * @param response
	 */
	public void printJsonToPage(Object object, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");  
		    response.setContentType("application/json; charset=utf-8");  
			SerializeWriter out = new SerializeWriter();
			JSONSerializer serializer = new JSONSerializer(out);
			serializer.write(object);
			out.writeTo(response.getWriter());
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	
	 public String export(HttpServletRequest request,HttpServletResponse  response,List<Object>  list) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		  // 文件名称与路径
		  String realPath = request.getRealPath("");
		  String fileName = "会议名单"+sdf.format(new Date())+".xls";
		  File file = new File(realPath + "//xxfzpj//tempPath//");//导出文件存放的位置
		  if (!file.exists()) {
		   file.mkdirs();
		  }
		  realPath = realPath + "//xxfzpj//tempPath//" + fileName;

		  // 建立工作薄并写表头
		  try {
		   WritableWorkbook wwb = Workbook.createWorkbook(new File(realPath));
		   WritableSheet ws = wwb.createSheet("Sheet1", 0);// 建立工作簿

		   // 写表头
		   jxl.write.Label label1 = new jxl.write.Label(0, 0, "姓名");
		   jxl.write.Label label2 = new jxl.write.Label(1, 0, "电话");

		   ws.addCell(label1);// 放入工作簿
		   ws.addCell(label2);

		   // 写入信息
		   

		   for (int i = 0; i < list.size(); i++) {
		  //  label1 = new jxl.write.Label(0, i + 1, list.get(i).getuName().toString().trim());// 建立第一列
		 //   label2 = new jxl.write.Label(1, i + 1, list.get(i).getPhone().toString().trim());// 建立第二列
		   
		    ws.addCell(label1);// 放入工作簿
		    ws.addCell(label2);
		   }

		   // 写入Exel工作表
		   wwb.write();
		   // 关闭Excel工作薄对象
		   wwb.close();

		   // 下载
		 //  FacesContext ctx = FacesContext.getCurrentInstance();

		  // downEmail(request ,response,realPath);
		  

		  } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }// 此处建立路径
		  return realPath;
		 }
	//下载
		public void down(HttpServletRequest request ,HttpServletResponse response,String path ){
		
			System.out.println(path+"__________");
			try {
					// path是指欲下载的文件的路径。
					File files = new File(path);
					// 取得文件名。
					String filenames = files.getName();
					// 取得文件的后缀名。
					String ext = filenames.substring(filenames.lastIndexOf(".") + 1).toUpperCase();
					// 以流的形式下载文件。
					InputStream fis = new BufferedInputStream(new FileInputStream(path));
					byte[] buffer = new byte[fis.available()];
					fis.read(buffer);
					fis.close();
					//清空response
					response.reset();
					//设置response的Header
					String filenameString = new String(filenames.getBytes("gbk"),"iso-8859-1");
					response.addHeader("Content-Disposition", "attachment;filename=" + filenameString);
					response.addHeader("Content-Length", "" + files.length());
					OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
					response.setContentType("application/octet-stream");
					toClient.write(buffer);
					toClient.flush();
					toClient.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
		
		public static String upload(File file,String fileName,HttpServletRequest request){
			
			  String root = request.getSession().getServletContext().getRealPath("/upload");
			  String imagePath="";
		    //循环上传的文件
		        InputStream is;
				try {
					imagePath="upload/"+fileName;
					is = new FileInputStream(file);
					 //得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
			          File destFile = new File(root,fileName);
			          
			          //把图片写入到上面设置的路径里
			          OutputStream os = new FileOutputStream(destFile);
			          byte[] buffer = new byte[400];
			          int length  = 0 ;
			          while((length = is.read(buffer))>0){
			              os.write(buffer, 0, length);
			          }
			          is.close();
			          os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		       
		     return   imagePath;
			
		}


		
		
		
}






