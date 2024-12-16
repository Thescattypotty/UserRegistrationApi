package org.authentication.userRegistration.Controller;

import org.authentication.userRegistration.Enum.ERole;
import org.authentication.userRegistration.Payload.Request.ChangePasswordRequest;
import org.authentication.userRegistration.Payload.Request.UserRequest;
import org.authentication.userRegistration.Payload.Response.UserResponse;
import org.authentication.userRegistration.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/api/v1/user")
@Tag(name = "User", description = "APIs for user management")
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}")
    @Operation(summary = "Update a user", description = "Update the details of a user by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> updateUser(@PathVariable("id") String id , @RequestBody @Valid UserRequest userRequest){
        userService.updateUser(id, userRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Fetch a user based on the provided user ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User found"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user", description = "Delete the user by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User deleted successfully"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/addrole/{id}")
    @Operation(summary = "Add role to user", description = "Assign a new role to the user by their ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Role added to user successfully"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "400", description = "Invalid role")
    })
    public ResponseEntity<Void> addRole(@PathVariable("id") String id , @RequestBody ERole role){
        userService.addRole(id, role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/removerole/{id}")
    @Operation(summary = "Remove role from user", description = "Remove a specific role from a user by their ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Role removed from user successfully"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "400", description = "Invalid role")
    })
    public ResponseEntity<Void> removeRole(@PathVariable("id") String id, @RequestBody ERole role) {
        userService.removeRole(id, role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updatepassword/{id}")
    @Operation(summary = "Update user password", description = "Change the password for the user by their ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Password updated successfully"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "400", description = "Invalid password data")
    })
    public ResponseEntity<Void> updatePassword(@PathVariable("id") String id, @RequestBody ChangePasswordRequest changePasswordRequest) {
        userService.updatePassword(id, changePasswordRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
