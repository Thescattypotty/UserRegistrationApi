package org.authentication.userRegistration.Service;

import java.util.UUID;

import org.authentication.userRegistration.Entity.User;
import org.authentication.userRegistration.EntityRepository.UserRepository;
import org.authentication.userRegistration.Enum.ERole;
import org.authentication.userRegistration.Exception.InvalidPasswordException;
import org.authentication.userRegistration.Exception.UserCreationFailedException;
import org.authentication.userRegistration.Exception.UserNotFoundException;
import org.authentication.userRegistration.IService.IUserService;
import org.authentication.userRegistration.Payload.Mapper.UserMapper;
import org.authentication.userRegistration.Payload.Request.ChangePasswordRequest;
import org.authentication.userRegistration.Payload.Request.RegisterRequest;
import org.authentication.userRegistration.Payload.Request.UserRequest;
import org.authentication.userRegistration.Payload.Response.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void createUser(RegisterRequest registerRequest) {
        try {
            User user = userMapper.toUser(registerRequest);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (IllegalArgumentException e) {
            throw new UserCreationFailedException("Cannot create User due to Illegal Argument");
        }
        
    }

    @Override
    @Transactional
    public void updateUser(String id, UserRequest userRequest) {
        User user = getUser(id);
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setPhone(userRequest.phone());
        user.setProfileImageUrl(userRequest.profileImageUrl());
        userRepository.save(user);
    }

    @Override
    public UserResponse getUserById(String id) {
        return userMapper.fromUser(getUser(id));
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        userRepository.delete(getUser(id));
    }

    @Override
    @Transactional
    public void addRole(String id, ERole role) {
        User user = getUser(id);
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void removeRole(String id, ERole role) {
        User user = getUser(id);
        user.getRoles().remove(role);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updatePassword(String id, ChangePasswordRequest changePasswordRequest) {
        User user = getUser(id);
        if(passwordEncoder.matches(changePasswordRequest.oldPassword(), user.getPassword())){
            user.setPassword(changePasswordRequest.newPassword());
        }else{
            throw new InvalidPasswordException("Password Incorrect");
        }

    }

    private User getUser(String id){
        return userRepository.findById(UUID.fromString(id))
            .orElseThrow(() -> new UserNotFoundException("User not foud"));
    }
    
}
