package com.tsystems.jschool20.srvengine.errors;

/**
 * Created by ruslbard on 30.05.2017.
 */
public class DatabaseException extends RuntimeException {
    public DatabaseException(String errorMsg) {
        super(errorMsg);
    }

    public DatabaseException(String errorMsg, Throwable ex) {
        super(errorMsg, ex);
    }
}
