package org.authentication.userRegistration.Payload.Request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request body for updating user information")
public record UserRequest(
    
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
