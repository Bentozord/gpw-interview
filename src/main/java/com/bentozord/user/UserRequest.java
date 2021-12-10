package com.bentozord.user;

import java.time.LocalDate;
import java.util.UUID;

record UserRequest(UUID id, String firstName, String lastName, String email, LocalDate birthDate) {

}
