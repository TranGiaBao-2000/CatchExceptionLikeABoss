package com.example.onetomany.handleException.exception;


import org.aspectj.bridge.Message;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String message){
        super(message);
    }
}
