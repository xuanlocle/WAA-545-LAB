package miu.waa.xuanloc.lab1.waalab1.service;

import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.UserEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity getUserById(long id);

    void createUser(UserDto userDto);

    List<PostEntity> getAllPostsOfUser(long userId);

    List<UserEntity> getAllUsersExistPost();
}
