package com.yishuailuo.iTest.controller.exceptionhandler;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luoyishuai on 17/7/30.
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponse> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .respCode(ErrorResponse.RESP_CODE_ERROR)
                .respMsg(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler()
    public ResponseEntity<ErrorResponse> handleEmptyResultDataAccessException(Exception exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .respCode(ErrorResponse.RESP_CODE_ERROR)
                .respMsg(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
