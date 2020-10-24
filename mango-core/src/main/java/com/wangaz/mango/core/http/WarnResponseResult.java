package com.wangaz.mango.core.http;

import com.wangaz.mango.core.constant.SysConstants;

public class WarnResponseResult extends ResponseResult{

	private Object data;
	
	private Object msg;
	
	private String flag;
	
	public WarnResponseResult() {
		super();
	}

	public  WarnResponseResult(Object msg) {
		this.msg = msg;
		this.flag = SysConstants.warnFlag;
	}
	
	public  WarnResponseResult(Object data,Object msg) {
		this.msg = msg;
		this.data = data;
		this.flag = SysConstants.warnFlag;
	}
	
	public  WarnResponseResult(StatusEnum status) {
		this.msg = status.getMessage();
		this.flag = getFlag(status.getCode());
	}
	
	public WarnResponseResult setResult(StatusEnum status) {
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
	
	public WarnResponseResult setData(Object data) {
		this.data = data;
		return this;
	}

	public WarnResponseResult setMsg(Object msg) {
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
