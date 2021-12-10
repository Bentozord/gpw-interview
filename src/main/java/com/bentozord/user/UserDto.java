package com.bentozord.user;

import java.time.LocalDate;
import java.time.Period;

record UserDto(String firstName, String lastName, String email, LocalDate birthDate) {

    public void validateUser() {
        validateAge();
        validateEmail();
        validateFirstName();
        validateLastName();
    }

    private void validateAge() {
        if (Period.between(birthDate, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Provided birth date is not valid for registration purpose");
        }
    }

    private void validateEmail() {
        //validation should be on contract level as well(some regex - be aware of complexity)
    }

    private void validateFirstName() {
        //validation should be on contract level as well
    }

    private void validateLastName() {
        //validation should be on contract level as well
    }
}
