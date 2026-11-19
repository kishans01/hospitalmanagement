package com.kxs.hospitalmanagement.exceptionHandler;

import com.kxs.hospitalmanagement.utility.ErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleException(GenericException exception){
        ErrorStructure error = new ErrorStructure();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }
}
