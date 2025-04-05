package com.arshpsps.yapbox.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String googleId) {
        super("User not found: " + googleId);
    }
}
