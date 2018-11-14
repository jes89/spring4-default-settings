
package com.brain.earthcitizenclub.util;

import java.lang.reflect.Array;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

public class StringUtil extends StringUtils {

	//html tag ����
	public static String SetRemoveHtmlTag(String str){
		return str.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}

	private static boolean isEmpty(Object object) {
		if (object == null){
			return true;
		}
		
		if (object instanceof String){
			String str = (String)object;
			return str.length() == 0;
		}
		
		if (object instanceof Collection){
			Collection collection = (Collection)object;
			return collection.size() == 0;
		}
		
		if (object.getClass().isArray()){
			try{
				if(Array.getLength(object) == 0){
					return true;
				}
			}catch(Exception e){}
		}
		
		return false;
	}
}
