package com.epam.jwd.exception;

public class IncorrectInputException extends Exception
{
    public IncorrectInputException(String errorType)
    {
        super(errorType);
    }
}
