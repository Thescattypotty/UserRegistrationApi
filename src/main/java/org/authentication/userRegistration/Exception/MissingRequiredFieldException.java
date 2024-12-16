package org.authentication.userRegistration.Exception;

public class MissingRequiredFieldException extends RuntimeException{
    public MissingRequiredFieldException(String message){
        super(message);
    }
}
