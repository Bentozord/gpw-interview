package com.bentozord.user

class InMemoryUserRepository implements UserRepository {

    Map<UUID, User> users = [:]

    @Override
    Optional<User> findById(UUID id) {
        return Optional.of(users[id])
    }

    @Override
    User save(User user) {
        users.put(user.getId(), user)
        return user
    }

    @Override
    void deleteById(UUID userId) {
        users.remove(userId)
    }

    def deleteAll() {
        users = [:]
    }
}
