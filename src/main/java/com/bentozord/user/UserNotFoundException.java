package com.bentozord.user;

import java.util.UUID;

class UserNotFoundException extends RuntimeException {

    UserNotFoundException(UUID userId) {
        super("No user found with userId: " + userId);
    }
}
