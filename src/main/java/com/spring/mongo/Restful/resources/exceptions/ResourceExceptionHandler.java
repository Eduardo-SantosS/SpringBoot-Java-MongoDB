package com.spring.mongo.Restful.resources.exceptions;

import com.spring.mongo.Restful.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objNotFound(ObjectNotFoundException e, HttpServletRequest request){
        Instant time = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = "Object not found";
        StandardError standardError = new StandardError(time, status.value(), e.getMessage(), message, request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
