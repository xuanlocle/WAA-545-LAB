package miu.waa.xuanloc.lab1.waalab1.controller;

import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.UserEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {

    @GetMapping("/users")
    List<UserEntity> getAllUsers(boolean isExistPost);

    @GetMapping("/users/{id}")
    UserEntity getUserById(@PathVariable("id") long id);

    @PostMapping("/users")
    void createUser(@RequestBody UserDto user);

    @GetMapping("/users/{id}/posts")
    List<PostEntity> getListPostOfUser(@PathVariable("id") long id);
}
