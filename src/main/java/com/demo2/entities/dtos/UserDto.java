package com.demo2.entities.dtos;

import lombok.Data;



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
    private Boolean isActive;
    private Long statusId;



}
