package com.bida.logoeat.logoeat.service.dto;

public class ForgotPasswordRequest {

    private String emailPhone;

    public ForgotPasswordRequest() {}

    public ForgotPasswordRequest(String emailPhone) {
        this.emailPhone = emailPhone;
    }

    public String getEmailPhone() {
        return emailPhone;
    }

    public void setEmailPhone(String emailPhone) {
        this.emailPhone = emailPhone;
    }
}
