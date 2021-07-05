package com.demo2.api.controllers;


import com.demo2.core.utilities.results.Result;

import com.demo2.service.abstracts.UserPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/addPicture")
@CrossOrigin
public class UserPicturesController {

    @Autowired
    UserPictureService userPictureService;

    @PutMapping("/userId")
    public Result addPicture(@RequestParam MultipartFile multipartFile, @RequestParam Long id) {

        return userPictureService.addPicture(multipartFile, id);

    }


}
