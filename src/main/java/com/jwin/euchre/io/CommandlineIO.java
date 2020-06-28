package com.jwin.euchre.io;

import com.jwin.euchre.exceptions.NoMoreInputException;

import java.util.Scanner;

public class CommandlineIO extends IOController {
    private static String noMoreMessage = "Command Line has no more input when expecting input";
    Scanner scanner;

    public CommandlineIO(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void outputString(String toOutput) {
        System.out.println(toOutput);
    }

    @Override
    public String inputStringWord() throws NoMoreInputException {
        if (!scanner.hasNext())
            throw new NoMoreInputException(noMoreMessage);
        return scanner.next();
    }

    @Override
    public void outputError(String errMessage) {
        System.err.println(errMessage);
    }

    @Override
    public void outputError(Exception exception) {
        System.err.println(exception.toString());
    }

    @Override
    public void inputStringLine() throws NoMoreInputException {
        if (!scanner.hasNextLine())
            throw new NoMoreInputException(noMoreMessage);
    }
}
