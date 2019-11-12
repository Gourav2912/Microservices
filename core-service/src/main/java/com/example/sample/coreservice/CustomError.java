package com.example.sample.coreservice;

import java.util.Date;

public class CustomError {
    public CustomError(Date time, String message) {
        this.time = time;
        this.message = message;
    }

    public CustomError() {
    }

    private Date time;
    private String message;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
