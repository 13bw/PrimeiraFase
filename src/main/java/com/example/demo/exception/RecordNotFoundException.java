package com.example.demo.exception;

public class RecordNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(String id) {
        super("Register not found. Id: " + id);
    }
    
}
