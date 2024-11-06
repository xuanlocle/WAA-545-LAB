package miu.waa.xuanloc.lab1.waalab1.service;


import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostEntity> getAllPosts();

    PostEntity getPostById(int id);

    void createPost(PostDto postDto, String username);

    List<PostEntity> getAllPostsByAuthor(String author);

    List<PostEntity> getAllPostsByAuthorContaining(String authorContain);

    void deletePost(int id);

    void updatePost(int id, PostDto postDto);

    List<PostEntity> getAllPostsMatchTitle(String title);
}
