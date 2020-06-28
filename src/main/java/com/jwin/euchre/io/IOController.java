package com.jwin.euchre.io;

import com.jwin.euchre.exceptions.NoMoreInputException;

public abstract class IOController {

    public abstract void outputString(String toOutput);

    public abstract String inputStringWord() throws NoMoreInputException;

    public abstract void outputError(String errMessage);

    public abstract void outputError(Exception exception);

    public abstract void inputStringLine() throws NoMoreInputException;

}
