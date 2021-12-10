package com.bentozord.user;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserFacade {

    private final UserRepository userRepository;
    private final UserCreator userCreator;


    public UserFacade(UserRepository userRepository, UserCreator userCreator) {
        this.userRepository = userRepository;
        this.userCreator = userCreator;
    }

    public UserDto get(UUID userId) {
        final Optional<User> user = userRepository.findById(userId);
        return user.map(User::dto).orElseThrow(() -> new UserNotFoundException(userId)); //Exception is natural behavior in systems, maybe better Fallback than throwing Exception?
    }


    public UUID create(UserDto userDto) {
        userDto.validateUser();
        final User user = userCreator.from(userDto);
        User createdUser = userRepository.save(user);
        return createdUser.getId();
    }

    public UserDto update(UserRequest userRequest) {
        final User user = userCreator.from(userRequest);
        User updatedUser = userRepository.save(user);
        return updatedUser.dto();
    }

    public void delete(UUID userId) {
        userRepository.deleteById(userId);
    }
}
