package com.bentozord.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfiguration {

    @Bean
    UserCreator userCreator() {
        return new UserCreator();
    }
}
