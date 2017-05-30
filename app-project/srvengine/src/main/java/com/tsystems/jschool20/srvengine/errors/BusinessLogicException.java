package com.tsystems.jschool20.srvengine.errors;

/**
 * Created by ruslbard on 30.05.2017.
 */
public class BusinessLogicException extends RuntimeException {
    public BusinessLogicException(String errorMsg) {
        super(errorMsg);
    }

    public BusinessLogicException(String errorMsg, Throwable ex) {
        super(errorMsg, ex);
    }
}
