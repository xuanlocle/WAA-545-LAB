package miu.waa.xuanloc.lab1.waalab1.service;

import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.PostDto;
import miu.waa.xuanloc.lab1.waalab1.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostEntity> getAllPosts() {
        return postRepository.getAllPosts();
    }

    @Override
    public PostEntity getPostById(int id) {
        return postRepository.getPostById(id);
    }

    @Override
    public void createPost(PostDto postDto) {
        postRepository.createPost(modelMapper.map(postDto, PostEntity.class));
    }

    @Override
    public List<PostEntity> getAllPostsByAuthor(String author) {
        return postRepository.getAllPostsByAuthor(author);
    }

    @Override
    public List<PostEntity> getAllPostsByAuthorContaining(String authorContain) {
        return postRepository.getAllPostsByAuthorContain(authorContain);
    }

    @Override
    public void deletePost(int id) {
        postRepository.deletePostById(id);
    }

    @Override
    public void updatePost(int id, PostDto postDto) {
        postRepository.updatePostById(id, modelMapper.map(postDto, PostEntity.class));
    }
}
