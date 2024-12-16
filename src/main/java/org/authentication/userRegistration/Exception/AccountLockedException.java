package org.authentication.userRegistration.Exception;

public class AccountLockedException extends RuntimeException{
    public AccountLockedException(String message){
        super(message);
    }
}
