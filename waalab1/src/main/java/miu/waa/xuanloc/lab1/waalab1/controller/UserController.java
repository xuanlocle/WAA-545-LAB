package miu.waa.xuanloc.lab1.waalab1.controller;

import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.UserEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.UserDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {

    List<UserEntity> getAllUsers(boolean isExistPost, int minPost);

    UserEntity getUserById(@PathVariable("id") long id);

    void createUser(@RequestBody UserDto user);

    void deleteUser(long id);

    List<PostEntity> getListPostOfUser(@PathVariable("id") long id);

    List<UserEntity> getUserByPostTitle(String title);
}
