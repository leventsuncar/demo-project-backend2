package com.demo2.dataAccess;

import com.demo2.entities.UserPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPictureDao extends JpaRepository<UserPicture, Long> {

    UserPicture findByUser_Id(Long id);

}
