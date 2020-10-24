package com.wangaz.mango.core.exception;

public class CurdException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 无参构造函数
	 */
    public CurdException(){
        super();
    }
    
    /**
     * 用详细信息指定一个异常
     * @param message
     */
    public CurdException(String message){
        super(message);
    }
    
    /**
     * 用指定的详细信息和原因构造一个新的异常
     * @param message
     * @param cause
     */
    public CurdException(String message, Throwable cause){
        super(message,cause);
    }
    
    /**
     * 用指定原因构造一个新的异常
     * @param cause
     */
    public CurdException(Throwable cause) {
        super(cause);
    }
}
