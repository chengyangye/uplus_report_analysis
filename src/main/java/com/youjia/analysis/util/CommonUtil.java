package com.youjia.analysis.util;

public class CommonUtil {
	
	public static String createInSql(Integer[] arr){
		StringBuffer inSql = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			if(i!=0){
				inSql.append(",");
			}
			inSql.append(arr[i]);
		}
		return inSql.toString();
	}
}
