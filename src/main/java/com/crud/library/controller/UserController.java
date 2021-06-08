package com.crud.library.controller;

import com.crud.library.domain.dto.UserDto;
import com.crud.library.mapper.UserMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private DbService service;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(service.getAllUsers());
    }

    @RequestMapping(method =  RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Long userId) throws NotFoundRecordException {
        return userMapper.maptoUserDto(service.getUserById(userId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addUser", consumes = APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody UserDto userDto) {
        userMapper.maptoUserDto(service.saveUser(userMapper.maptoUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public void updateUser(@RequestBody UserDto userDto) {
        userMapper.maptoUserDto(service.saveUser(userMapper.maptoUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam Long userId) {
        service.deleteUser(userId);
    }
}
