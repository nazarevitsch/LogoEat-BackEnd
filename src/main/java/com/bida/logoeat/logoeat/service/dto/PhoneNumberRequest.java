package com.bida.logoeat.logoeat.service.dto;

public class PhoneNumberRequest {

    private String phoneNumber;

    public PhoneNumberRequest(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumberRequest() {}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
