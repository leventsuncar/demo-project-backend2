package com.demo2.dataAccess;

import com.demo2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long > {

    User findByFirstName(String firstName);
    User findUserByUserName(String userName);
    List<User> findAllByIsActiveTrue();


}
