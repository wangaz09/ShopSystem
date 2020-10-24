package com.wangaz.mango.core.http;

import com.wangaz.mango.core.constant.SysConstants;

public class ResponseResult {

	private Object data;
	
	private Object msg;
	
	private String flag;
	
	public ResponseResult() {
	}

	public  ResponseResult(Object msg) {
		this.msg = msg;
		this.flag = SysConstants.successFlag;
	}
	
	public  ResponseResult(Object data,Object msg) {
		this.msg = msg;
		this.data = data;
		this.flag = SysConstants.successFlag;
	}
	
	public  ResponseResult(StatusEnum status) {
		this.msg = status.getMessage();
		this.flag = getFlag(status.getCode());
	}
	
	public ResponseResult setResult(StatusEnum status) {
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
	
	public ResponseResult setData(Object data) {
		this.data = data;
		return this;
	}

	public ResponseResult setMsg(Object msg) {
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
