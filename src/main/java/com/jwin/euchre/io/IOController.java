package com.jwin.euchre.io;

public abstract class IOController {

    public abstract void outputString(String toOutput);

    public abstract String inputString();

    public abstract void outputError(String errMessage);

    public abstract void outputError(Exception exception);


}
