package com.bentozord.user.assertions

import com.bentozord.user.UserFacade

class UserAssertion {

    UserFacade users
    UUID userId

    UserAssertion(UserFacade users, UUID userId) {
        this.users = users
        this.userId = userId
    }

    static assertThat(UserFacade users, UUID userId) {
        return new UserAssertion(users, userId)
    }

    def hasBeenCreated() {
        assert users.get(userId) != null
        return this
    }
}
