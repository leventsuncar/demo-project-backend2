package com.demo2.entities.dtos;

import lombok.Data;

import java.io.File;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String password;
    private String userName;
    private String email;
    private String confirmPassword;
    private String pictureURL;



}
