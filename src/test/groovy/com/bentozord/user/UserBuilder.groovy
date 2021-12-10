package com.bentozord.user


import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

import java.time.LocalDate

@Builder(builderStrategy = SimpleStrategy, prefix = '')
class UserBuilder { //can be mover to proper package builder but had to change UserDto visibility

    String firstName = 'defaultName'
    String lastName = 'defaultLastName'
    String email = 'default@gmail.com'
    LocalDate birthDate = LocalDate.of(1990, 1, 1)

    UserBuilder() {
    }

    static singleUser(@DelegatesTo(UserBuilder) Closure builder) {
        def user = new UserBuilder()
        user.with(builder)
        return user.build()
    }

    private def build() {
        return new UserDto(firstName, lastName, email, birthDate)
    }
}
