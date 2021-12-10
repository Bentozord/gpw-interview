package com.bentozord.user

import spock.lang.Specification

import java.time.LocalDate

import static com.bentozord.user.assertions.UserAssertion.assertThat
import static com.bentozord.user.UserBuilder.singleUser

class UserSpec extends Specification {

    UserCreator creator = new UserCreator()
    UserRepository repository = new InMemoryUserRepository() //I could mock both of this or I could make a bean for it in config

    UserFacade users = new UserFacade(repository, creator)

    def 'should create simple user'() {
        given: 'simple user'
            def user = singleUser {
                firstName 'Chris'
                lastName 'Peterson'
                email 'chris@gmail.com'
                birthDate LocalDate.of(1989,03,10)
            }

        when: 'creating user'
            def userId = users.create(user)

        then:
            assertThat(users, userId).hasBeenCreated()
    }

    def 'should find user by id'() {
        given: 'user is in the database'
            def user = singleUser {}
            def userId = users.create(user)

        expect: 'system to return the user'
            users.get(userId) == user
    }

    def 'should throw an IllegalArgumentException with proper message when user is under aged'() {
        given: 'under aged user'
            def underAgedUser = singleUser {birthDate LocalDate.of(2020, 1, 1)}

        when: 'trying to add under aged user'
            users.create(underAgedUser)

        then:
            def exception = thrown(IllegalArgumentException)
            exception.message == "Provided birth date is not valid for registration purpose"
    }

    def 'should delete user by id if it is in the system'() {

    }

    def 'should thrown an UserNotFoundException when there is no user with given id'() {

    }

    def cleanup() { //remember about the state of you db
        repository.deleteAll()
    }

    //cover the business functionalities/requirements
}
