package org.authentication.userRegistration.Payload.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.Set;
import org.authentication.userRegistration.Enum.ERole;

@Schema(description = "Response body containing user details")
public record UserResponse(

    @Schema(description = "The unique ID of the user", example = "12345")
    String id,

    @Schema(description = "The username of the user", example = "johndoe123")
    String username,

    @Schema(description = "The email address of the user", example = "johndoe@example.com")
    String email,

    @Schema(description = "The first name of the user", example = "John")
    String firstName,

    @Schema(description = "The last name of the user", example = "Doe")
    String lastName,

    @Schema(description = "The phone number of the user", example = "+123456789")
    String phone,

    @Schema(description = "The roles assigned to the user", example = "[\"USER\", \"ADMIN\"]")
    Set<ERole> roles,

    @Schema(description = "Indicates if the user is active", example = "true")
    Boolean isActive,

    @Schema(description = "Indicates if the user account is locked", example = "false")
    Boolean isLocked,

    @Schema(description = "The number of failed login attempts", example = "3")
    Integer failedLoginAttempts,

    @Schema(description = "The profile image URL of the user", example = "http://example.com/profile.jpg")
    String profileImageUrl,

    @Schema(description = "The timestamp of the user's last login", example = "2024-12-16T10:00:00")
    LocalDateTime lastLogin,

    @Schema(description = "Indicates if the user account is enabled", example = "true")
    Boolean enabled,

    @Schema(description = "The timestamp when the user was created", example = "2024-01-01T10:00:00")
    LocalDateTime createdAt,

    @Schema(description = "The timestamp when the user was last updated", example = "2024-12-01T10:00:00")
    LocalDateTime updatedAt
) {
}
