package com.demo2.service.concretes;

import com.demo2.core.adapters.cloudinary.CloudinaryService;
import com.demo2.core.utilities.results.DataResult;
import com.demo2.core.utilities.results.ErrorResult;
import com.demo2.core.utilities.results.Result;
import com.demo2.core.utilities.results.SuccessResult;
import com.demo2.dataAccess.UserDao;
import com.demo2.dataAccess.UserPictureDao;
import com.demo2.entities.User;
import com.demo2.entities.UserPicture;
import com.demo2.service.abstracts.UserPictureService;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class UserPictureManager implements UserPictureService {

    @Autowired
    UserPictureDao userPictureDao;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    UserDao userDao;


    @Override
    public Result addPicture(MultipartFile multipartFile, Long id) {
       User user1 = userDao.getById(id);
        if (user1 == null) return new ErrorResult("Kullanıcı Bulunamadı");
        DataResult<Map<String, String>> result = this.cloudinaryService.upload(multipartFile);
        if(!result.isSuccess()) {
            return new ErrorResult("İşlem başarısız");
        }
        UserPicture picture = new UserPicture();
        picture.setUser(user1);
        picture.setPictureURL(result.getData().get("url"));

        userPictureDao.save(picture);
        return new SuccessResult("Photo added");

    }

    @Override
    public Result deletePicture(Long id) {
        User user = userDao.getById(id);
        user.getUserPicture().setPictureURL("");
        userDao.save(user);

        return new SuccessResult("Resim silindi");
    }

    @Override
    public void photoTableSetter(User user) {
    return;
    }
}
