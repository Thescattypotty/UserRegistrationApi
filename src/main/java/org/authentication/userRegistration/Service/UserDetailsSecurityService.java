package org.authentication.userRegistration.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.authentication.userRegistration.Entity.User;
import org.authentication.userRegistration.EntityRepository.UserRepository;
import org.authentication.userRegistration.Enum.ERole;
import org.authentication.userRegistration.Exception.UserNotFoundException;
import org.authentication.userRegistration.Payload.Security.UserDetailsSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsSecurityService implements UserDetailsService{
    
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UserNotFoundException("User Not Found"));

        return UserDetailsSecurity.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .password(user.getPassword())
            .authorities(mapGrantedAuthority(user.getRoles()))
            .build();
    }

    private List<SimpleGrantedAuthority> mapGrantedAuthority(Set<ERole> roles) {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (ERole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        }
        return authorities;
    }
    
}
