package com.example.sample.coreservice;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleanyexception(Exception ex, WebRequest request){
       // CustomError err= new CustomError(new Date(),"Erorrrrrrrrrrrrrrrrrrr");
        return new ResponseEntity<>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


/*    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Object> handlenullexception(NullPointerException ex, WebRequest request){

        return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
    }*/

}

