package com.bentozord.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
class User {

    @Id
    UUID id;
    String firstName;
    String lastName;
    String email;
    LocalDate birthDate;

    UserDto dto() {
        return new UserDto(firstName, lastName, email, birthDate); // we should use builder here
    }

    public User() {
    }

    public User(UUID id, String firstName, String lastName, String email, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && birthDate.equals(user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, birthDate);
    }
}
