package org.example.authservice.exceptions;

public class UserNotCreatedException extends RuntimeException{

    public UserNotCreatedException(String msg) {
        super(msg);
    }
}
