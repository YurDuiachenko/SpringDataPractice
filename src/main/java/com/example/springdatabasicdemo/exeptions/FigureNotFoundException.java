package com.example.springdatabasicdemo.exeptions;

public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(Long id) {
        super("Could not find figure " + id);
    }
}