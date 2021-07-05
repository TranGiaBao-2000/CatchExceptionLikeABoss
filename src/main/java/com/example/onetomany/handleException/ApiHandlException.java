package com.example.onetomany.handleException;

import com.example.onetomany.handleException.exception.RoleNotFoundException;
import com.example.onetomany.model.ErrorMessage;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiHandlException {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage Error(NumberFormatException e) {
        System.out.println("123");
        return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage RoleNotFoundException(RoleNotFoundException e) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
    }

}
