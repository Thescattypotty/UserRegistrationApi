package org.authentication.userRegistration.Exception;

public class InvalidVerificationTokenException extends RuntimeException{
    public InvalidVerificationTokenException(String message){
        super(message);
    }
}
