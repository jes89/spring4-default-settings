package com.brain.earthcitizenclub.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileReaderUtil {
	
	
	public String getEmailHTMLForSleepUser(String filePath,String userNm,String fireDate) {
		StringBuffer sb = new StringBuffer();
//		try {
//			File file = new File(filePath);
//			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//			String data = "";
//			while ((data = reader.readLine()) != null) {
//				sb.append(data);
//				
//				if (data.contains("userNmArea")) {
//					sb.append(userNm);
//				}
//				if (data.contains("fireDateArea")) {
//					sb.append(fireDate);
//				}
//			}
//			reader.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return sb.toString();
	}
	
//	public String getEmailHTML(String filePath,InquireDTO inquire) {
//		StringBuffer sb = new StringBuffer();
//		try {
//			File file = new File(filePath);
//			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//			String data = "";
//			while ((data = reader.readLine()) != null) {
//				sb.append(data);
//				
//				if (data.contains("questionTargetUserNm")) {
//					sb.append(inquire.getUserNm());
//				}
//				
//				if (data.contains("questionTargetTitle")) {
//					sb.append(inquire.getTitle());
//				}
//				
//				if (data.contains("questionTargetContent")) {
//					sb.append(inquire.getContents());
//				}
//				
//				if (data.contains("contentsTargetArea")) {
//					sb.append(inquire.getAnswerContents());
//				}
//			}
//			reader.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}
}
