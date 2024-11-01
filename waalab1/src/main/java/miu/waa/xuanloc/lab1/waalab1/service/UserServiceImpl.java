package miu.waa.xuanloc.lab1.waalab1.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.UserEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.UserDto;
import miu.waa.xuanloc.lab1.waalab1.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(UserDto userDto) {
        userRepository.saveAndFlush(modelMapper.map(userDto, UserEntity.class));
    }

    @Override
    public List<PostEntity> getAllPostsOfUser(long userId) {
        final UserEntity user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.getPosts();
        } else {
            return null;
        }
    }

    @Override
    public List<UserEntity> getAllUsersExistPost() {
        return userRepository.findAllByPostsIsNotEmpty();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntity> getAllUsersMoreThanNPost(int minPost) {
        return userRepository.findAllByPostsIsGreaterThan(minPost);
    }

    @Override
    public List<UserEntity> getUsersWhosePostTitle(String title) {
        return userRepository.findAllByPostsTitleIgnoreCase(title);
    }

}
