package com.cx.bank.exception;

//根据国际化文件显示相应的内容
public class AppException extends RuntimeException {

    private Object[] args;
    
    private String errorCode;
	
    public AppException (String errorCode) {
        this.errorCode = errorCode;
    }
    
    public AppException(String errorCode, String args0) {
        this(errorCode, new Object[]{args0});
    }
    
    public AppException(String errorCode, Object[] args) {
        this.errorCode = errorCode;
        this.args = args;
    }
    
    public String getErrorCode() {
        return this.errorCode;
    }

    public Object[] getArgs() {
        return args;
    }
}
