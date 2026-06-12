package com.agrohub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.agrohub.entity.User;
import com.agrohub.repository.UserRepository;

import com.agrohub.jwt.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }
    
    public String loginUser(User user) {

        Optional<User> existingUser =
                userRepository.findByUsername(user.getUsername());

        if(existingUser.isPresent()) {

            User dbUser = existingUser.get();

            boolean passwordMatch =
                    passwordEncoder.matches(
                            user.getPassword(),
                            dbUser.getPassword()
                    );

            if(passwordMatch) {
            	return JwtUtil.generateToken(
            	        dbUser.getUsername(),
            	        dbUser.getRole()
            	);
            }
        }

        return "Invalid Username or Password";
    }
    
    
}