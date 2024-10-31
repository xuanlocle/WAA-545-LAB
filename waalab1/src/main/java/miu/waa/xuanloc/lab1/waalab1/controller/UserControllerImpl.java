package miu.waa.xuanloc.lab1.waalab1.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.UserEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.UserDto;
import miu.waa.xuanloc.lab1.waalab1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService service;

    @GetMapping
    @Override
    public List<UserEntity> getAllUsers(@RequestParam(value = "isExistPost", required = false) boolean isExistPost) {
        if (isExistPost) {
            return service.getAllUsersExistPost();
        }
        return service.getAllUsers();
    }

    @GetMapping("{id}")
    @Override
    public UserEntity getUserById(@PathVariable("id") long id) {
        return service.getUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Override
    public void createUser(@RequestBody UserDto user) {
        service.createUser(user);
    }


    @GetMapping("{id}/posts")
    @Override
    public List<PostEntity> getListPostOfUser(@PathVariable("id") long id) {
        return service.getAllPostsOfUser(id);
    }

}
