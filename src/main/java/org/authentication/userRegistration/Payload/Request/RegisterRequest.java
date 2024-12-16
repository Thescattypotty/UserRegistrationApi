package org.authentication.userRegistration.Payload.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request body for user registration")
public record RegisterRequest(

    @NotNull
    @NotBlank
    @Schema(description = "The username of the user", example = "johndoe123")
    String username,

    @NotNull
    @NotBlank
    @Email
    @Schema(description = "The email address of the user", example = "johndoe@example.com")
    String email,

    @NotNull
    @NotBlank
    @Schema(description = "The password of the user", example = "securepassword123")
    String password,

    @Schema(description = "The first name of the user", example = "John")
    String firstName,

    @Schema(description = "The last name of the user", example = "Doe")
    String lastName,

    @Schema(description = "The phone number of the user", example = "+123456789")
    String phone,
    
    @Schema(description = "The profile image URL of the user", example = "http://example.com/image.jpg")
    String profileImageUrl
) {
}
