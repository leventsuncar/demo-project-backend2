package com.demo2.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_statuses")
public class UserStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "status_name", unique = true, nullable = false)
    private String statusName;

    @Column(name = "status_level", nullable = false)
    private String statusLevel;


    // join
    @Column(name = "role_privilege", nullable = false)
    private String accessPrivilege;


}
