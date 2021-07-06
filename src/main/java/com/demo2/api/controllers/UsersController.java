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

    @GetMapping("/getUser")
    public DataResult<UserDto> getById(@RequestParam Long id){
        return userService.getById(id);
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }


    @PutMapping("/deleteUser")
    public Result softDelete(@RequestParam Long id) {
        return userService.softDelete(id);
    }

    @PutMapping("/activateUser")
    public Result activateUser(@RequestParam Long id) {
        return userService.activateUser(id);
    }


    @PutMapping("/updateUser")
    public void updateUser(@RequestParam Long id, @RequestBody User user) {
        userService.updateUser(user, id);
    }


    @GetMapping("/signIn")
    public Result signIn(@RequestParam String userName, @RequestParam String password) {
        return userService.signIn(userName, password);
    }


    @GetMapping("/activeUsers")
    public DataResult<List<UserDto>> activeUsers(){
        return userService.findAllByIsActiveTrue();
    }
}
