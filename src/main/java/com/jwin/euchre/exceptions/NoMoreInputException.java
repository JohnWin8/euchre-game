package com.jwin.euchre.exceptions;

public class NoMoreInputException extends Exception{
    public NoMoreInputException(String message){
        super(message);
    }

    public NoMoreInputException(String message, Throwable cause){
        super(message, cause);
    }
}
