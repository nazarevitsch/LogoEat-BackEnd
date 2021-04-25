package com.bida.logoeat.logoeat.config;

import com.bida.logoeat.logoeat.domain.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "occupiedEmail")
    public Message emailAlreadyOccupied() {
        return new Message("Email is already Occupied.");
    }

    @Bean(name = "userIsSuccessfulRegistered")
    public Message userIsSuccessfulRegistered() {
        return new Message("User is successful Registered.");
    }

    @Bean(name = "unacceptableEmailOrPassword")
    public Message unacceptableEmailOrPassword() {
        return new Message("Password or Email is unacceptable.");
    }
}
