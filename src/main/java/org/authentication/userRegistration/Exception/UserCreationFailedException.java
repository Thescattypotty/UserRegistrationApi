package org.authentication.userRegistration.Exception;

public class UserCreationFailedException extends RuntimeException{
    public UserCreationFailedException(String message){
        super(message);
    }
}
