package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private UserDbService userDbService;
    private UserMapper userMapper;

    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(userDbService.getAllUsers());
    }

    @GetMapping(value = "getUser")
    public UserDto getUser(@RequestParam Long id) {
        return userMapper.mapToUserDto(userDbService.getUser(id).get());
    }

    @PostMapping(value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userDbService.saveUser(userMapper.mapToUser(userDto));
    }

    @PutMapping(value = "updateUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userDbService.saveUser(userMapper.mapToUser(userDto)));
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUser(@RequestParam Long id) {
        userDbService.deleteUser(id);
    }

    @PutMapping(value = "blockUser")
    public void blockUser(@RequestParam Long id) {
        userDbService.blockUser(id);
    }

    @GetMapping(value = "generateUserKey")
    public Long generateUserKey(@RequestParam Long id) {
        userDbService.generateKey(id);
        return userDbService.getUser(id).get().getUserKey();
    }
    @GetMapping(value = "setTimer")
    public void setTimer(@RequestParam Long id) {
        userDbService.setTimer(id);
        userDbService.getUser(id).get().getUserKey();
    }
}


