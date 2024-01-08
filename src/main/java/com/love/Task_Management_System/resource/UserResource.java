package com.love.Task_Management_System.resource;


import com.love.Task_Management_System.model.Roles;
import com.love.Task_Management_System.model.Users;

import java.util.HashSet;
import java.util.Set;

public class UserResource {
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;
    private String phoneNumber;
    private Set<Roles> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public UserResource() {}

    public UserResource(Users user) {
        this.id = user.getId();
        this.firstName= user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.roles= user.getRoles();
        this.phoneNumber=user.getPhone();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}