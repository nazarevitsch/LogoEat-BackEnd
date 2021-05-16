package com.bida.logoeat.logoeat.service.dto;

import com.bida.logoeat.logoeat.domain.User;

public class UserRegistrationDTO {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public UserRegistrationDTO(){}

    public UserRegistrationDTO(String name, String email, String password){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser(){
        User user = new User();
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        return user;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
