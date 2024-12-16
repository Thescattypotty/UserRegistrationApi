package org.authentication.userRegistration.Component;



import java.time.LocalDateTime;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.authentication.userRegistration.Entity.User;
import org.authentication.userRegistration.EntityRepository.UserRepository;
import org.authentication.userRegistration.Exception.AccountLockedException;
import org.authentication.userRegistration.Exception.AccountNotEnabledException;
import org.authentication.userRegistration.Exception.EmailAlreadyExistsException;
import org.authentication.userRegistration.Exception.InvalidPasswordException;
import org.authentication.userRegistration.Exception.RoleNotFoundException;
import org.authentication.userRegistration.Exception.UserNotFoundException;
import org.authentication.userRegistration.Payload.Request.LoginRequest;
import org.authentication.userRegistration.Payload.Request.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class AuthenticationAspectComponent {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Before("execution(* org.authentication.userRegistration.Service.AuthenticationService.login(..)) && args(loginRequest)")
    public void beforeLogin(LoginRequest loginRequest){
        User user = userRepository.findByUsername(loginRequest.username())
            .orElseThrow(() -> new UserNotFoundException("User not found"));

        if(user.getFailedLoginAttempts() > 5){
            user.setIsLocked(true);
            userRepository.save(user);
            throw new AccountLockedException("This Account Reached Limits of Failing Attempts (Contact Administrator)");
        }
        if(!user.getEnabled()){
            throw new AccountNotEnabledException("This account is not enabled");
        }
        if(user.getIsLocked()){
            throw new AccountLockedException("This Account is Locked");
        }
        if(user.getRoles().isEmpty()){
            throw new RoleNotFoundException("This Account do not contain any role");
        }
        if(!passwordEncoder.matches(loginRequest.password(), user.getPassword())){
            user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);
            userRepository.save(user);
            throw new InvalidPasswordException("Password Incorrect");
        }
        user.setLastLogin(LocalDateTime.now());
        user.setFailedLoginAttempts(0);
        userRepository.save(user);
    }
    
    @Before("execution(* org.authentication.userRegistration.Service.AuthenticationService.register(..)) && args(registerRequest)")
    public void beforeRegister(RegisterRequest registerRequest) {
        if(userRepository.existsByEmail(registerRequest.email())){
            throw new EmailAlreadyExistsException("This Email already Exist");
        }
        if (userRepository.existsByUsername(registerRequest.username())) {
            throw new EmailAlreadyExistsException("This Username already Exist");
        }
    }
}
