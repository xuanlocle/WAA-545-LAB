package miu.waa.xuanloc.lab1.waalab1.controller;

import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.PostDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PostController {

    List<PostEntity> getAllPosts(String author, String authorContain);

    PostEntity getPostById(int id);

    void createPost(PostDto postEntity);

    void deletPost(@PathVariable("id") int id);

    @PutMapping("/{id}")
    void update(@PathVariable("id") int id, @RequestBody PostDto p);
}
