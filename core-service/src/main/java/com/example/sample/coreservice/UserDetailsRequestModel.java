package com.example.sample.coreservice;




import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {


    @NotNull(message = "Can not be null")
    private String firstName;
    @NotNull(message = "Can not be null")
    private String lastName;

    @NotNull(message="Email can not be null")
    @Email
    private String emailId;

    @NotNull(message="Password can not be null")
    @Size(min = 2,max = 9)
    private String password;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
