package org.authentication.userRegistration.Payload.Security;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsSecurity implements UserDetails{
    private UUID id;

    private String username;

    private String email;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;
}
