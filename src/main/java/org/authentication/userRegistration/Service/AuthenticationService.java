package org.authentication.userRegistration.Service;

import java.util.Set;
import java.util.stream.Collectors;

import org.authentication.userRegistration.Enum.ERole;
import org.authentication.userRegistration.Exception.InvalidCredentialsException;
import org.authentication.userRegistration.IService.IAuthenticationService;
import org.authentication.userRegistration.Payload.Request.LoginRequest;
import org.authentication.userRegistration.Payload.Request.RegisterRequest;
import org.authentication.userRegistration.Payload.Response.JwtResponse;
import org.authentication.userRegistration.Payload.Security.UserDetailsSecurity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService{

    private final UserService userService;
    private final JwtUtilityService jwtUtilityService;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(RegisterRequest registerRequest) {
        userService.createUser(registerRequest);
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
            );
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Bad Credentials");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsSecurity userDetailsSecurity = (UserDetailsSecurity) authentication.getPrincipal();

        String accessToken = jwtUtilityService.generateToken(
            userDetailsSecurity.getUsername(),
            Set.copyOf(
                userDetailsSecurity.getAuthorities()
                    .stream()
                    .map(auth -> ERole.valueOf(auth.getAuthority()))
                    .collect(Collectors.toSet())
                ),
            "ACCESS"
            );

        return new JwtResponse(
            userDetailsSecurity.getId().toString(),
            accessToken,
            userDetailsSecurity.getUsername(),
            userDetailsSecurity.getEmail(),
            Set.copyOf(
                userDetailsSecurity.getAuthorities()
                    .stream()
                    .map(auth -> ERole.valueOf(auth.getAuthority()))
                    .collect(Collectors.toSet())
                )
            );
    }
    
}
