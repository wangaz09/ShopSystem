package com.wangaz.mango.core.page;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class PageRequest {

	/**
	 * 当前页码
	 */
	private int pageNum = 1;
	
	private int pageSize = 10;
	
	private Map<String, Object> paramsMap = new HashMap<String, Object>();
}
