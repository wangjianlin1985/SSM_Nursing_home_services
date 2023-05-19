/**
 * 
 */
package com.jxxt.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author mike
 *
 */
public class PDFReader {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("D:/新建文件夹/酸洗SPHC/Z431017A1304.pdf");
		list.add("D:/新建文件夹/冷轧钢带SPCC/Z43091761514.pdf");
		list.add("D:/新建文件夹/冷轧钢带SPCC/ZP3041772913.pdf");
		list.add("D:/新建文件夹/冷轧钢带SPCC/ZR3221760690.pdf");
		list.add("D:/新建文件夹/冷成型MCFC/Z431017A0294.pdf");
		list.add("D:/新建文件夹/镀锌DX51D/Z13191730402.pdf");
		list.add("D:/新建文件夹/镀锌DX51D/Z43081761044.pdf");
		list.add("D:/新建文件夹/镀锌DX51D/Z43081780482.pdf");
		list.add("D:/新建文件夹/镀锌DX51D/ZP30417A0842.pdf");
		getStr(list);
		// PDDocument document;
		// try {
		// document = PDDocument.load(new
		// File("D:/新建文件夹/冷轧钢带SPCC/ZR3221760690.pdf"));
		// PDFTextStripper pdfStripper = new PDFTextStripper();
		// // 获取页码
		// int pages = document.getNumberOfPages();
		// pdfStripper.setSortByPosition(true);
		// pdfStripper.setStartPage(1);
		// pdfStripper.setEndPage(pages);
		//
		// String content = pdfStripper.getText(document);
		// System.out.println(content);
		// String[] strs=content.split("\r\n");
		// String zbabm=strs[5];
		// String type=strs[9];
		// String wldm=strs[16];
		// String saphth=strs[18];
		// if(content.indexOf("热轧酸洗板")!=-1){
		// type="热轧酸洗板";
		// }
		//
		// if(content.indexOf("冷轧钢带")!=-1){
		// type="冷轧钢带";
		// }
		//
		// if(content.indexOf("产 品 名 称： 全工艺冷轧无取向电工钢")!=-1){
		// type="全工艺冷轧无取向电工钢带";
		// }
		//
		// if(content.indexOf("产 品 名 称： 全工艺冷轧无取向电工钢")!=-1){
		// type="全工艺冷轧无取向电工钢带";
		// wldm=strs[14];
		// saphth=strs[17];
		// }
		// if(content.indexOf("产品名称： 彩色涂层钢带")!=-1){
		// type="彩色涂层钢带";
		// String _zmsh=strs[7];
		// zbabm=_zmsh.substring(_zmsh.lastIndexOf(": ")+1);
		//
		// String _ph=strs[11];
		// wldm=_ph.split(" ")[1];
		//
		// String _htbh=strs[9];
		// saphth=_htbh.substring(_htbh.lastIndexOf("：")+1);
		// }
		// exportExecl(strs,type,zbabm,wldm,saphth);
		//
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public static void getStr(List<String> list) {
		for (String str : list) {
			/*PDDocument document;
			try {
				document = PDDocument.load(new File(str));
				PDFTextStripper pdfStripper = new PDFTextStripper();
				// 获取页码
				int pages = document.getNumberOfPages();
				pdfStripper.setSortByPosition(true);
				pdfStripper.setStartPage(1);
				pdfStripper.setEndPage(pages);

				String content = pdfStripper.getText(document);
				String[] strs = content.split("\r\n");
				System.out.println(content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}

	public static List exportExecl(String[] records, String type, String zbabm, String wldm, String saphth)
			throws Exception {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		int beginIndex = 0;

		if ("热轧酸洗板".equals(type)) {
			beginIndex = 84;
		} else if ("冷轧钢带".equals(type)) {
			beginIndex = 111;
		} else if ("镀锌钢带".equals(type)) {
			beginIndex = 114;
		} else if ("彩色涂层钢带".equals(type)) {
			beginIndex = 74;
		} else if ("全工艺冷轧无取向电工钢带".equals(type)) {
			beginIndex = 101;
		}
		for (int i = beginIndex; i < records.length; i++) {
			String record = records[i];
			String[] conts = record.split(" ");
			Map<String, String> map = new HashMap<String, String>();
			map.put("PDNO", conts[0]);
			map.put("ZBSBM", zbabm);
			map.put("WLDM", wldm);
			map.put("GG", conts[2] + "*" + conts[3] + "*" + conts[4]);
			map.put("JZ", conts[5]);
			map.put("SAPHTH", saphth);

			if ("热轧酸洗板".equals(type)) {
				if ("— — — — — — — — — — — — — — — — — — — — — — — — — — — —".equals(record))
					break;
				Float hcl = new Float(Float.parseFloat(conts[6]) * 0.0001f);
				map.put("HCL", hcl.toString());
				map.put("QFQD", conts[19]);
				map.put("KLQD", conts[20]);
				map.put("SCL", conts[21]);
				map.put("BMCL", " ");
				map.put("XCZL", " ");
				map.put("BMZLDJ", conts[25]);
				map.put("BYZT", conts[27]);
				map.put("ZYQX", conts[26]);
			} else if ("冷轧钢带".equals(type)) {
				if ("— — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — —".equals(record))
					break;
				Float hcl = new Float(Float.parseFloat(conts[6]) * 0.0001f);
				map.put("HCL", hcl.toString());
				map.put("QFQD", conts[22]);
				map.put("KLQD", conts[23]);
				map.put("SCL", conts[24]);
				map.put("BMCL", " ");
				map.put("XCZL", " ");
				map.put("BMZLDJ", conts[32]);
				map.put("BYZT", " ");
				map.put("ZYQX", conts[34]);
			} else if ("镀锌钢带".equals(type)) {
				if ("— — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — —".equals(record))
					break;
				Float hcl = new Float(Float.parseFloat(conts[6]) * 0.0001f);
				map.put("HCL", hcl.toString());
				map.put("QFQD", conts[16]);
				map.put("KLQD", conts[17]);
				map.put("SCL", conts[18]);
				map.put("BMCL", conts[23]);
				map.put("XCZL", conts[26]);
				map.put("BMZLDJ", conts[30]);
				map.put("BYZT", " ");
				map.put("ZYQX", conts[32]);
			} else if ("彩色涂层钢带".equals(type)) {
				if (record.startsWith("/ / / / / / / / / / / / / / / "))
					break;
				map.put("PDNO", conts[1]);
				map.put("HCL", " ");
				map.put("QFQD", " ");
				map.put("KLQD", " ");
				map.put("SCL", " ");
				map.put("BMCL", " ");
				String _xczl = records[11];
				map.put("XCZL", _xczl.split(" ")[2]);
				map.put("BMZLDJ", conts[23]);
				map.put("BYZT", " ");
				map.put("ZYQX", " ");
			} else if ("全工艺冷轧无取向电工钢带".equals(type)) {
				if (record.startsWith("合计     TOTAL"))
					break;
				map.put("HCL", " ");
				map.put("QFQD", " ");
				map.put("KLQD", " ");
				map.put("SCL", " ");
				map.put("BMCL", " ");
				map.put("XCZL", " ");
				map.put("BMZLDJ", conts[13]);
				map.put("BYZT", conts[12]);
				map.put("ZYQX", " ");
			}
			list.add(map);
		}

		return list;

	}

}
