package com.tsystems.jschool20.controllers.errors;


import com.tsystems.jschool20.srvengine.errors.BusinessLogicException;
import com.tsystems.jschool20.srvengine.errors.DatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ruslbard on 30.05.2017.
 */
@ControllerAdvice
public class CustomExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger("MainControllersLogger");


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception ex) {
        logger.error("ERROR", ex);
        return "Unknown error";
    }

    @ExceptionHandler(BusinessLogicException.class)
    @ResponseBody
    public String handleBusinessLogicException(BusinessLogicException ex) {
        logger.warn("WARN", ex);
        return ex.getMessage();
    }

    @ExceptionHandler(DatabaseException.class)
    @ResponseBody
    public String handleDatabaseException(Throwable ex) {
        logger.error("ERROR", ex);
        return ex.getMessage();
    }


}