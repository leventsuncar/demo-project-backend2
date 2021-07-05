package com.demo2.dataAccess;

import com.demo2.entities.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusDao extends JpaRepository<UserStatus, Long > {
}
