package org.authentication.userRegistration.Payload.Mapper;

import java.util.Set;

import org.authentication.userRegistration.Entity.User;
import org.authentication.userRegistration.Enum.ERole;
import org.authentication.userRegistration.Payload.Request.RegisterRequest;
import org.authentication.userRegistration.Payload.Response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toUser(RegisterRequest registerRequest){
        return User.builder()
            .username(registerRequest.username())
            .email(registerRequest.email())
            .password(registerRequest.password())
            .roles(Set.of(ERole.ROLE_USER))
            .firstName(registerRequest.firstName())
            .lastName(registerRequest.lastName())
            .phone(registerRequest.phone())
            .failedLoginAttempts(0)
            .profileImageUrl(registerRequest.profileImageUrl())
            .isLocked(false)
            .isActive(true)
            .enabled(true)
            .build();
    }
    public UserResponse fromUser(User user){
        return new UserResponse(
            user.getId().toString(),
            user.getUsername(),
            user.getEmail(),
            user.getFirstName(),
            user.getLastName(),
            user.getPhone(),
            user.getRoles(),
            user.getIsActive(),
            user.getIsLocked(),
            user.getFailedLoginAttempts(),
            user.getProfileImageUrl(),
            user.getLastLogin(),
            user.getEnabled(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );
    }
}
