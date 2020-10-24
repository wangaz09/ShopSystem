package com.wangaz.mango.core.http;

public enum StatusEnum {
	SUCCESS_GET("1", "查询成功"), FALL_GET("-1", "查询失败"), REQUEST_PARAM_ERROR("-1", "请求参数错误"),
	SUCCESS_SAVE("1", "保存成功"), FALL_SAVE("-1", "保存失败"),
	SUCCESS_DEL("1", "删除成功"), FALL_DEL("-1", "删除失败"),FALL_LOGIN("-1", "登录失败!"),
	WARN_OPERATION("0","警告");

    private String code;

    private String message;

    StatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
