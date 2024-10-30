package miu.waa.xuanloc.lab1.waalab1.controller;

import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.PostDto;
import miu.waa.xuanloc.lab1.waalab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class PostControllerImpl implements PostController {

    @Autowired
    PostService postService;


    @GetMapping("/posts")
    @Override
    public List<PostEntity> getAllPosts(
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "authorContain", required = false) String authorContain) {

        //only 'author' or 'authorContain' provide
        if (author != null && authorContain != null) {
            throw new IllegalArgumentException("Please provide only one parameter: either 'author' or 'authorContain'.");
        }

        if (author != null && !author.isEmpty()) {
            return postService.getAllPostsByAuthor(author);
        }

        if (authorContain != null && !authorContain.isEmpty()) {
            return postService.getAllPostsByAuthorContaining(authorContain);
        }

        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    @Override
    public PostEntity getPostById(@PathVariable("id") int id) {
        return postService.getPostById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/posts")
    @Override
    public void createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/posts/{id}")
    @Override
    public void deletPost(@PathVariable("id") int id) {
        postService.deletePost(id);
    }

    @PutMapping("/posts/{id}")
    @Override
    public void update(@PathVariable("id") int id, @RequestBody PostDto postDto) {
        postService.updatePost(id, postDto);
    }
}
