package org.authentication.userRegistration.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request body for user login")
public record LoginRequest(

    @NotBlank
    @Schema(description = "The username of the user", example = "johndoe123")
    String username,

    @NotBlank
    @Schema(description = "The password of the user", example = "securepassword123")
    String password
) {
}
