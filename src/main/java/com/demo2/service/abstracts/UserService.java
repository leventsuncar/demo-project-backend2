package com.demo2.service.abstracts;

import com.demo2.core.utilities.results.DataResult;
import com.demo2.core.utilities.results.Result;
import com.demo2.entities.User;
import com.demo2.entities.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserService {
    DataResult<List<UserDto>> getAll();
    DataResult<UserDto> getById(Long id);

    Result addUser(UserDto userDto);
    Result softDelete(Long id);
    DataResult<List<UserDto>> findAllByIsActiveTrue();
    Result activateUser(Long id);
    Result updateUser(User user , Long id);

}
