package com.example.serenadegx.opensource.business;

public class BusinessResult {
    private String code;
    private String message;
    private String name;

    public BusinessResult(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
