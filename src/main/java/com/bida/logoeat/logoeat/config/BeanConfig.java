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

    @Bean(name = "noSuchEmailOrPhone")
    public Message noSuchEmailOrPassword() {
        return new Message("No such Email or PhoneNumber.");
    }

    @Bean(name = "SMSNotificationIsNotAvailable")
    public Message SMSNotificationIsNotAvailable() {
        return new Message("SMS notification is NOT available!");
    }

    @Bean(name = "emailNotificationIsNotAvailable")
    public Message emailNotificationIsNotAvailable() {
        return new Message("Email notification is NOT available!");
    }

    @Bean(name = "SMSWithNewPassword")
    public Message SMSWithNewPassword() {
        return new Message("SMS with new password was sent.");
    }

    @Bean(name = "emailWithNewPassword")
    public Message EmailWithNewPassword() {
        return new Message("Email with new password was sent.");
    }

    @Bean(name = "numberWasChanged")
    public Message numberWasChanged() {
        return new Message("Number was changed.");
    }

    @Bean(name = "invalidPhoneNumber")
    public Message invalidPhoneNumber() {
        return new Message("Invalid phone number.");
    }

    @Bean(name = "nameWasChanged")
    public Message nameWasChanged() {
        return new Message("Name was changed.");
    }

    @Bean(name = "invalidName")
    public Message invalidName() {
        return new Message("Invalid name.");
    }

    @Bean(name = "invalidPassword")
    public Message invalidPassword() {
        return new Message("Invalid password.");
    }

    @Bean(name = "oldPasswordAndNewPasswordAreSimilar")
    public Message oldPasswordAndNewPasswordAreSimilar() {
        return new Message("Old password and new password are similar.");
    }

    @Bean(name = "oldPasswordWrong")
    public Message oldPasswordWrong() {
        return new Message("Old password is wrong.");
    }

    @Bean(name = "passwordWasChanged")
    public Message passwordWasChanged() {
        return new Message("Password was changed.");
    }
}
