package com.bentozord.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("users")
class UserEndpoint {

    private final UserFacade users; //DI only via constructor for proper initialization and test usage

    UserEndpoint(UserFacade users) {
        this.users = users;
    }

    @GetMapping("{userId}")
    UserDto get(@PathVariable("userId") final UUID userId) {
        requireNonNull(userId);
        return users.get(userId);
    }

    @PostMapping
    UUID create(@RequestBody final UserDto user) {
        requireNonNull(user);
        return users.create(user);
    }

    @PutMapping
    UserDto update(@RequestBody final UserRequest user) { //we don't want to use domain object here
        requireNonNull(user);
        return users.update(user);
    }

    @DeleteMapping("{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT) //additional handle in this method to make it idempotent
    void delete(@PathVariable("userId") final UUID userId) {
        requireNonNull(userId);
        users.delete(userId);
    }
}
