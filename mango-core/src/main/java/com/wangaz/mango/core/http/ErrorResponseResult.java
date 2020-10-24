package com.wangaz.mango.core.http;

import com.wangaz.mango.core.constant.SysConstants;

public class ErrorResponseResult extends ResponseResult{

	private Object data;
	
	private Object msg;
	
	private String flag;
	
	public ErrorResponseResult() {
		super();
	}

	public  ErrorResponseResult(Object msg) {
		this.msg = msg;
		this.flag = SysConstants.errorFlag;
	}
	
	public  ErrorResponseResult(Object data,Object msg) {
		this.msg = msg;
		this.data = data;
		this.flag = SysConstants.errorFlag;
	}
	
	public  ErrorResponseResult(StatusEnum status) {
		this.msg = status.getMessage();
		this.flag = getFlag(status.getCode());
	}
	
	public ErrorResponseResult setResult(StatusEnum status) {
		this.msg = status.getMessage();
		this.flag = getFlag(status.getCode());
		return this;
	}

	public Object getData() {
		return data;
	}

	public Object getMsg() {
		return msg;
	}
	
	public ErrorResponseResult setData(Object data) {
		this.data = data;
		return this;
	}

	public ErrorResponseResult setMsg(Object msg) {
		this.msg = msg;
		return this;
	}

	public String getFlag() {
		return flag;
	}

	public String getFlag(String code) {
		if(SysConstants.errorCode.equals(code)) {
			return SysConstants.errorFlag;
		}else if(SysConstants.warnCode.equals(code)) {
			return SysConstants.warnFlag;
		}else if(SysConstants.successCode.equals(code)) {
			return SysConstants.successFlag;
		}else {
			return SysConstants.undefined;
		}
	}
	
	
	
}
