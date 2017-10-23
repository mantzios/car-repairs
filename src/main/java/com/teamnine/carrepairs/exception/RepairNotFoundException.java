package com.teamnine.carrepairs.exception;

public class RepairNotFoundException extends Exception {

    public RepairNotFoundException(String message){
      super(message);
    }

    public RepairNotFoundException(String message, Throwable t){
        super(message,t);
    }
}
