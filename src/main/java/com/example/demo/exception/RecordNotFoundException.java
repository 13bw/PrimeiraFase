package com.example.demo.exception;

import java.util.UUID;

public class RecordNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(UUID id) {
        super("Register not found. Id: " + id);
    }
    
}
