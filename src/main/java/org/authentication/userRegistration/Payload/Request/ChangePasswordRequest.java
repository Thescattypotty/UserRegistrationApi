package org.authentication.userRegistration.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request body for changing user password")
public record ChangePasswordRequest(

    @NotNull
    @NotBlank
    @Schema(description = "The user's old password", example = "oldpassword123")
    String oldPassword,

    @NotNull
    @NotBlank
    @Schema(description = "The user's new password", example = "newpassword123")
    String newPassword
) {
}
