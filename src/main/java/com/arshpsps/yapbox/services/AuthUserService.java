package com.arshpsps.yapbox.services;

import org.springframework.stereotype.Service;

import com.arshpsps.yapbox.models.AuthUser;
import com.arshpsps.yapbox.repository.AuthUserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthUserService {
    private AuthUserRepository authUserRepository;

    public AuthUser getUser(String id) {
        return this.authUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User doesn't exist"));
    }

    public AuthUser saveUser(AuthUser authUser) {
        return this.authUserRepository.save(authUser);
    }

}
