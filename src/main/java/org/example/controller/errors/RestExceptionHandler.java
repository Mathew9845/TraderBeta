package org.example.controller.errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class RestExceptionHandler extends RuntimeException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(HttpServletRequest req, RuntimeException ex) {

        String error = "Unable to register user " + ex.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new  ResponseEntity<Object>(errorResponse,errorResponse.getStatus());
    }
 }
