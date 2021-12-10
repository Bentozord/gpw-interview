package com.bentozord.user;


import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

interface UserRepository extends Repository<User, UUID> {

    Optional<User> findById(UUID id);

    User save(User user);

    void deleteById(UUID userId);
}
