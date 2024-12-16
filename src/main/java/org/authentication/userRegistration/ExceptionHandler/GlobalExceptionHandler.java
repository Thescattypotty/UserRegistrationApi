package org.authentication.userRegistration.ExceptionHandler;

import javax.security.auth.login.AccountLockedException;

import org.authentication.userRegistration.Exception.AccountNotEnabledException;
import org.authentication.userRegistration.Exception.EmailAlreadyExistsException;
import org.authentication.userRegistration.Exception.InvalidCredentialsException;
import org.authentication.userRegistration.Exception.InvalidPasswordException;
import org.authentication.userRegistration.Exception.MissingRequiredFieldException;
import org.authentication.userRegistration.Exception.RoleNotFoundException;
import org.authentication.userRegistration.Exception.UserCreationFailedException;
import org.authentication.userRegistration.Exception.UserNotFoundException;
import org.authentication.userRegistration.Exception.UsernameAlreadyExistsException;
import org.authentication.userRegistration.Payload.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle AccountLockedException
    @ExceptionHandler(AccountLockedException.class)
    public ResponseEntity<ErrorResponse> handleException(AccountLockedException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    // Handle AccountNotEnabledException
    @ExceptionHandler(AccountNotEnabledException.class)
    public ResponseEntity<ErrorResponse> handleException(AccountNotEnabledException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    // Handle EmailAlreadyExistsException
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleException(EmailAlreadyExistsException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle InvalidCredentialsException
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleException(InvalidCredentialsException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    // Handle InvalidPasswordException
    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorResponse> handleException(InvalidPasswordException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle MissingRequiredFieldException
    @ExceptionHandler(MissingRequiredFieldException.class)
    public ResponseEntity<ErrorResponse> handleException(MissingRequiredFieldException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle RoleNotFoundException
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(RoleNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle UserCreationFailedException
    @ExceptionHandler(UserCreationFailedException.class)
    public ResponseEntity<ErrorResponse> handleException(UserCreationFailedException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle UsernameAlreadyExistsException
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleException(UsernameAlreadyExistsException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle UserNotFoundException
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(UserNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
