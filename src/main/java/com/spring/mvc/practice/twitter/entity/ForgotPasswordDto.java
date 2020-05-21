package com.spring.mvc.practice.twitter.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ForgotPasswordDto {

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
