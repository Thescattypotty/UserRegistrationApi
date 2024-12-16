package org.authentication.userRegistration.IService;

import org.authentication.userRegistration.Enum.ERole;
import org.authentication.userRegistration.Payload.Request.ChangePasswordRequest;
import org.authentication.userRegistration.Payload.Request.RegisterRequest;
import org.authentication.userRegistration.Payload.Request.UserRequest;
import org.authentication.userRegistration.Payload.Response.UserResponse;

public interface IUserService {
    void createUser(RegisterRequest registerRequest);
    
    void updateUser(String id , UserRequest userRequest);
    
    UserResponse getUserById(String id);

    void deleteUser(String id);

    void addRole(String id , ERole role);

    void removeRole(String id , ERole role);

    void updatePassword(String id , ChangePasswordRequest changePasswordRequest);
}
