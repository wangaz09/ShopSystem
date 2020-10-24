package com.wangaz.mango.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wangaz.mango.core.exception.CurdException;
import com.wangaz.mango.core.page.PageRequest;
import com.wangaz.mango.core.page.PageResult;
@Service
public interface CurdService<T> {

	int save(T record) throws CurdException;
	
	int delete (T record) throws CurdException;
	
	int deleteById (String id) throws CurdException;
	
	int delete(List<T> records) throws CurdException;
	
	T findById(String id);
	
	List<T> findAll();
	
	PageResult findPage(PageRequest pageRequest);
	
	void checkCanDelete(T record) throws CurdException ;
	
	void checkCanUpdate(T record) throws CurdException;
	
	void checkCanInsert(T record) throws CurdException;
	
}
