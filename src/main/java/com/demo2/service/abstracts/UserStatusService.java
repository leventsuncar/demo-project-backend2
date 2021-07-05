package com.demo2.service.abstracts;

import com.demo2.entities.UserStatus;

import java.util.List;

public interface UserStatusService  {
    List<UserStatus> getAllStatuses();
    void addStatus(UserStatus userStatus);
    void deleteStatus(Long id);
}
