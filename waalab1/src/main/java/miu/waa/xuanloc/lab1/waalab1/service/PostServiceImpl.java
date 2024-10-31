package miu.waa.xuanloc.lab1.waalab1.service;

import lombok.RequiredArgsConstructor;
import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.PostDto;
import miu.waa.xuanloc.lab1.waalab1.repository.PostJpaRepository;
import miu.waa.xuanloc.lab1.waalab1.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

//    @Autowired
//    PostRepository postRepository;

    private final PostJpaRepository postJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostEntity> getAllPosts() {
//        return postRepository.getAllPosts();
        return postJpaRepository.findAll();
    }

    @Override
    public PostEntity getPostById(int id) {
//        return postRepository.getPostById(id);
        return postJpaRepository.findById(((long) id)).orElse(null);
    }

    @Override
    public void createPost(PostDto postDto) {
//        postRepository.createPost(modelMapper.map(postDto, PostEntity.class));
        postJpaRepository.save(modelMapper.map(postDto, PostEntity.class));
    }

    @Override
    public List<PostEntity> getAllPostsByAuthor(String author) {
//        return postRepository.getAllPostsByAuthor(author);
        return postJpaRepository.findAllByAuthor(author);
    }

    @Override
    public List<PostEntity> getAllPostsByAuthorContaining(String authorContain) {
//        return postRepository.getAllPostsByAuthorContain(authorContain);
        return postJpaRepository.findAllByAuthorContains(authorContain);
    }

    @Override
    public void deletePost(int id) {
//        postRepository.deletePostById(id);
        postJpaRepository.deleteById((long)id);
    }

    @Override
    public void updatePost(int id, PostDto postDto) {
//        postRepository.updatePostById(id, modelMapper.map(postDto, PostEntity.class));
        PostEntity existingPost = postJpaRepository.findById((long)id)
                .orElse(null);
        if(existingPost == null) {
            return;
        }
        modelMapper.map(postDto, existingPost);
        postJpaRepository.save(existingPost);
    }
}
