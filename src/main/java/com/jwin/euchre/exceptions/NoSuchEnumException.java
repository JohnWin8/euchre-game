package com.jwin.euchre.exceptions;

public class NoSuchEnumException extends Exception{
    public NoSuchEnumException(String message){
        super(message);
    }

    public NoSuchEnumException(String message, Throwable cause){
        super(message, cause);
    }
}
