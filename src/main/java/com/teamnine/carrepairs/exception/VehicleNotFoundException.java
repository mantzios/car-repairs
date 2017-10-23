package com.teamnine.carrepairs.exception;

public class VehicleNotFoundException extends Exception {


    public VehicleNotFoundException(String message){
        super(message);
    }

    public VehicleNotFoundException(String message, Throwable t){
        super(message,t);
    }
}
