package com.example.clinicmanagementappbackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String status;

    public User(String status) {
        this.status = status;
    }

}
