package com.arshpsps.yapbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arshpsps.yapbox.models.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
}
