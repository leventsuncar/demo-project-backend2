package com.demo2.service.concretes;

import com.demo2.dataAccess.UserStatusDao;
import com.demo2.entities.UserStatus;
import com.demo2.service.abstracts.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatusManager implements UserStatusService {

    @Autowired
    private UserStatusDao userStatusDao;


    @Override
    public List<UserStatus> getAllStatuses() {
        return userStatusDao.findAll();
    }

    @Override
    public void addStatus(UserStatus userStatus) {
        userStatusDao.save(userStatus);
    }

    @Override
    public void deleteStatus(Long id) {
        UserStatus userStatus = userStatusDao.getById(id);
        userStatusDao.delete(userStatus);
    }
}
