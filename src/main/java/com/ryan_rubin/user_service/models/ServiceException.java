package com.ryan_rubin.user_service.models;

public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }
}
