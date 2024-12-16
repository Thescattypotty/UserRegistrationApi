package org.authentication.userRegistration.Exception;

public class AccountNotEnabledException extends RuntimeException{
    public AccountNotEnabledException(String message){
        super(message);
    }
}
