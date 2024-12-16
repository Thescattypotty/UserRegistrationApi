package org.authentication.userRegistration.Payload.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Response body for error messages")
public record ErrorResponse(

    @Schema(description = "The error message", example = "Invalid username or password")
    String message,

    @Schema(description = "The timestamp when the error occurred", example = "2024-12-16T10:00:00")
    LocalDateTime timestamp
) {
}
