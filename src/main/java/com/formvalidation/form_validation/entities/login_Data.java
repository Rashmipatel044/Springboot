package com.formvalidation.form_validation.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class login_Data {
    @NotBlank(message = "User Name cannot be empty!!")
    @Size(min = 3, max = 12, message = "user name must be in between 3-12 character")
    private String userName;
    @AssertTrue
    private boolean agreed;

    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "invalid Email")
    private String email;

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "login_Data [userName=" + userName + ", email=" + email + "]";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }
}
