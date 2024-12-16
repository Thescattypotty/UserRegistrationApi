package org.authentication.userRegistration.Exception;

public class InvalidPhoneNumberException extends RuntimeException{
    public InvalidPhoneNumberException(String message){
        super(message);
    }
}
