package com.socialbridge.user.service.impl;

import com.socialbridge.user.model.User;
import com.socialbridge.user.repository.RoleRepository;
import com.socialbridge.user.repository.UserRepository;
import com.socialbridge.user.service.UserService;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        if (user != null) {
            user.setRole(roleRepository.findById(2l).get());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        throw new BadRequestException("User cannot be 'null'");
    }
}
