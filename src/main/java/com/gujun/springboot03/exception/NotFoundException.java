package com.gujun.springboot03.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 7914775888117094683L;

    private String errorMsg;

    public NotFoundException() {
    }

    public NotFoundException(String errorMsg) {
        super();
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
