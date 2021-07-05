package com.demo2.api.controllers;

import com.demo2.core.utilities.results.DataResult;
import com.demo2.core.utilities.results.Result;
import com.demo2.entities.User;
import com.demo2.entities.dtos.UserDto;
import com.demo2.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {

    @Autowired
    UserService userService;


    @GetMapping("/getUsers")
    public DataResult<List<UserDto>> getAll() {
        return userService.getAll();
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserDto userDto) {
       return userService.addUser(userDto);
    }


    @PutMapping("/deleteUser")
    public Result softDelete(@RequestParam Long id) {
        return userService.softDelete(id);
    }


    @GetMapping("/getUsersActive")
    public DataResult<List<UserDto>> findAllByIsActiveTrue() {
        return userService.findAllByIsActiveTrue();
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user, @RequestParam Long id){
        userService.updateUser(user,id);
    }
}
