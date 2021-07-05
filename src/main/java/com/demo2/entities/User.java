package com.demo2.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.File;

@Data
@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "previous_password")
    private String previousPassword;

    @Column(name = "status_id")
    private Long statusId;



}
