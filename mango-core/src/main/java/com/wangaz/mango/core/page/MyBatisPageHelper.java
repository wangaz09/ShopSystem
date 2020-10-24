package com.wangaz.mango.core.page;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangaz.mango.common.util.ReflectUtil;

public class MyBatisPageHelper {
	
	public static final String FINDPAGE_STRING = "findPage";
	
	public static PageResult findPage( PageRequest pageRequest,Object mapper) {
		return findPage(pageRequest, mapper,FINDPAGE_STRING);
	}

	public static PageResult findPage( PageRequest pageRequest,Object mapper,String queryMethodName,Object... args) {
		int pageNum = pageRequest.getPageNum();
		int pageSize = pageRequest.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		Object result = ReflectUtil.execute(mapper, queryMethodName);
		return getPageResult(pageRequest, new PageInfo((List<?>) result));
	}
	
	private static PageResult getPageResult(PageRequest pageRequest,PageInfo<?> pageInfo) {
		PageResult pageResult = new PageResult();
		pageResult.setPageNum(pageInfo.getPageNum());
		pageResult.setPageSize(pageInfo.getPageSize());
		pageResult.setTotalPages(pageInfo.getPages());
		pageResult.setTotalSize(pageInfo.getTotal());
		pageResult.setContent(pageInfo.getList());
		return pageResult;
	}
}
