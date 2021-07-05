package com.demo2.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_picture")
public class UserPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "picture_id")
    private Long id;

    @Column(name = "picture_url")
    private String pictureURL;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;
}
