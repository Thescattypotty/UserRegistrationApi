package org.authentication.userRegistration.IService;

import org.authentication.userRegistration.Payload.Request.LoginRequest;
import org.authentication.userRegistration.Payload.Request.RegisterRequest;
import org.authentication.userRegistration.Payload.Response.JwtResponse;

public interface IAuthenticationService {
    void register(RegisterRequest registerRequest);
    JwtResponse login(LoginRequest loginRequest);
}
