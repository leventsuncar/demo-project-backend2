package com.demo2.api.controllers;

import com.demo2.entities.UserStatus;
import com.demo2.service.abstracts.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/status")
public class UserStatusesController {

    @Autowired
    private UserStatusService userStatusService;

    @GetMapping("/get/all")
    public List<UserStatus> getAllStatuses() {
        return userStatusService.getAllStatuses();
    }

    @PostMapping("/add")
    public void addStatus(@RequestBody UserStatus userStatus) {
        userStatusService.addStatus(userStatus);
    }

    @DeleteMapping("/delete")
    public void deleteStatus(@RequestParam Long id){
        userStatusService.deleteStatus(id);
    }
}
