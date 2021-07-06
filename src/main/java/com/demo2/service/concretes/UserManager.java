package com.demo2.service.concretes;

import com.demo2.core.utilities.results.*;
import com.demo2.dataAccess.UserDao;
import com.demo2.entities.User;
import com.demo2.entities.dtos.UserDto;
import com.demo2.service.abstracts.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired


    @Override
    public DataResult<List<UserDto>> getAll() {
        List<User> users = userDao.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = modelMapper.map(user, UserDto.class);

            userDtoList.add(userDto);
        }
        return new SuccessDataResult<List<UserDto>>(userDtoList, "Kullanıcı listesi");


        //        return new SuccessDataResult<List<UserDto>>(users
//                .stream().map(user -> modelMapper
//                        .map(user, UserDto.class))
//                .collect(Collectors.toList()));

    }

    @Override
    public DataResult<UserDto> getById(Long id) {
        User user = userDao.getById(id);
        UserDto userDto = modelMapper.map(userDao.getById(id), UserDto.class);


        return new SuccessDataResult<UserDto>(userDto);
    }


    @Override
    public Result addUser(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);
        user.setStatusId(1L);
        user.setIsActive(true);
        userDao.save(user);
        return new SuccessResult("Kullanıcı Eklendi");
    }

    @Override
    public Result softDelete(Long id) {
        User user = userDao.getById(id);
        user.setIsActive(false);
        userDao.save(user);
        return new SuccessResult("Kullanıcı Silindi");
    }

    @Override
    public DataResult<List<UserDto>> findAllByIsActiveTrue() {

        List<User> users = userDao.findAllByIsActiveTrue();
        return new SuccessDataResult<List<UserDto>>(users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList()));
    }

    @Override
    public Result activateUser(Long id) {
        User user = userDao.getById(id);
        user.setIsActive(true);
        userDao.save(user);
        return new SuccessResult("Kullanıcı Aktifleştirildi");
    }

    @Override
    public Result updateUser(User user, Long id) {


        User user1 = userDao.getById(id);
        if (user1 != null) {


            if (!user.getStatusId().equals(0)) {
                user1.setStatusId(user.getStatusId());
            }
            if (user.getUserName().length() != 0) {
                user1.setUserName(user.getUserName());
            }
            if (user.getEmail().length() != 0) {
                user1.setEmail(user.getEmail());
            }
            if (user.getIsActive() != null) {
                user1.setIsActive(user.getIsActive());
            }
            if (user.getLastName().length() != 0) {
                user1.setLastName(user.getLastName());
            }
            if (user.getFirstName().length() != 0)
                user1.setFirstName(user.getFirstName());

            if (user.getPhoneNumber() != 0) {
                user1.setPhoneNumber(user.getPhoneNumber());
            }

            if (user.getPassword().length() != 0) {
                //eğer şifre değişirse
                user1.setPreviousPassword(user1.getPassword());
                //var olan şifre previous passworda atılır
                user1.setPassword(user.getPassword());
                //parametreden gelen şifre ise password e atanır
            }
        }else{
            return new ErrorResult("Kullanıcı Bulunamadı");
        }


        user1.setId(id);
        //her ihtimale karşı parametreden gelen id yi atıyorum.


        //Bu kod hiç hoşuma gitmedi. Belki frontendde hallederim.
        //Daha iyi yolu bulunacak

        userDao.delete(user);
        //eski user'ı siliyorum
        userDao.save(user1);
        //yenisini kaydediyorum

        return new SuccessResult("Kullanıcı Güncellendi");

    }

    @Override
    public Result signIn(String userName, String password) {
        User user = userDao.findUserByUserName(userName);
        if (user != null && user.getIsActive().equals(true)) {
            if (user.getPassword().equals(password)) {
                return new SuccessResult("Giriş Yapılıyor");
            } else {
                return new ErrorResult("Şifre Hatalı");
            }

        } else {
            return new ErrorResult("Kullanıcı Adı Hatalı");
        }

    }

    public User findUserName(String name) {
        return userDao.findUserByUserName(name);
    }
}
