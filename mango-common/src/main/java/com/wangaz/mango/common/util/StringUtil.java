package com.wangaz.mango.common.util;

public class StringUtil {

	public static boolean isEmpty(Object object) {
		if(object == null || "".equals(object.toString().trim())) {
			return true;
		}
		return false;
	}
}
