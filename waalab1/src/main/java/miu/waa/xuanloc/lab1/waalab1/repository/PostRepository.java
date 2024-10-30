package miu.waa.xuanloc.lab1.waalab1.repository;


import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;

import java.util.List;

public interface PostRepository{

    List<PostEntity> getAllPosts();

    PostEntity getPostById(int id);

    void createPost(PostEntity post);

    List<PostEntity> getAllPostsByAuthor(String author);

    List<PostEntity> getAllPostsByAuthorContain(String authorContain);

    void deletePostById(int id);

    void updatePostById(int id, PostEntity postDto);
}
