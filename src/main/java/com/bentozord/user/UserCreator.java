package com.bentozord.user;

import java.util.UUID;

class UserCreator {

    User from(UserDto userDto) {
        return new User(UUID.randomUUID(), userDto.firstName(), userDto.lastName(), userDto.email(), userDto.birthDate()); //builder here
    }

    User from(UserRequest user) {
        return new User(user.id(), user.firstName(), user.lastName(), user.email(), user.birthDate()); //builder here
    }
}
