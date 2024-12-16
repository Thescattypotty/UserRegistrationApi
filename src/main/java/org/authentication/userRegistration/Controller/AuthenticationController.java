package org.authentication.userRegistration.Controller;

import org.authentication.userRegistration.Payload.Request.LoginRequest;
import org.authentication.userRegistration.Payload.Request.RegisterRequest;
import org.authentication.userRegistration.Payload.Response.JwtResponse;
import org.authentication.userRegistration.Service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication", description = "APIs for user authentication (login, registration)")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @Operation(summary = "Register a new user", description = "Create a new user with registration details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Registration successful"),
        @ApiResponse(responseCode = "400", description = "Invalid registration data or email/username already exists"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest registerRequest){
        authenticationService.register(registerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    @Operation(summary = "User login", description = "Authenticate user with login credentials")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "400", description = "Invalid credentials (wrong username or password)"),
            @ApiResponse(responseCode = "401", description = "Account is locked or not enabled"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        return ResponseEntity.ok(authenticationService.login(loginRequest));
    }
}
