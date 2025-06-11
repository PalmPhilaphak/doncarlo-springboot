package com.doncarlo.doncarlo.http.exceptions.customs;

public class NotFoundException extends RuntimeException {

    public NotFoundException()
    {
        super("NOT FOUND");
    }

    public NotFoundException(String message)
    {
        super(message);
    }

}
