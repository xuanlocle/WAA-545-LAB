package miu.waa.xuanloc.lab1.waalab1.service;

import lombok.RequiredArgsConstructor;
import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.UserEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.PostDto;
import miu.waa.xuanloc.lab1.waalab1.repository.PostJpaRepository;
import miu.waa.xuanloc.lab1.waalab1.repository.UserRepository;
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
    private final AuthenticationService authenticationService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

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
    public void createPost(PostDto postDto, String username) {
//        postRepository.createPost(modelMapper.map(postDto, PostEntity.class));
        PostEntity entityToSave = modelMapper.map(postDto, PostEntity.class);
        UserEntity user = userRepository.findByEmail(username);
        entityToSave.setUser(user);
        entityToSave.setAuthor(username);
        postJpaRepository.save(entityToSave);
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

    @Override
    public List<PostEntity> getAllPostsMatchTitle(String title) {
        return postJpaRepository.findAllByTitleIgnoreCase(title);
    }
}
