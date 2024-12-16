package org.authentication.userRegistration.Payload.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Set;
import org.authentication.userRegistration.Enum.ERole;

@Schema(description = "Response body for authentication containing JWT token and user details")
public record JwtResponse(
    @Schema(description = "User Id", example = "12345678-1234-5678-1234-567812345678")
    String id,

    @Schema(description = "The JWT token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJqb2huZG9lMTIzIiwiaWF0IjoxNjI5OTg1ODIyfQ.kUgRfbvA2u5vOVwpRJW67IQ7BsjY3sB2_FHhxK6oCU0")
    String token,

    @Schema(description = "The username of the authenticated user", example = "johndoe123")
    String username,

    @Schema(description = "The email of the authenticated user", example = "johndoe@example.com")
    String email,

    @Schema(description = "The roles assigned to the user", example = "[\"USER\", \"ADMIN\"]")
    Set<ERole> roles
) {
}
