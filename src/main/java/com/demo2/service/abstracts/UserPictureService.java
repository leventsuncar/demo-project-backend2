package com.demo2.service.abstracts;


import com.demo2.core.utilities.results.Result;
import com.demo2.entities.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserPictureService {

    Result addPicture(MultipartFile file, Long id);
    Result deletePicture(Long id);
    public void photoTableSetter(User user);

}
