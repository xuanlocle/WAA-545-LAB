package miu.waa.xuanloc.lab1.waalab1.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.xuanloc.lab1.waalab1.entity.CommentEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.CommentDto;
import miu.waa.xuanloc.lab1.waalab1.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class CommentControllerImpl implements CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{id}/comment")
    @Override
    public void addCommentToPost(@PathVariable("id") long postId, @RequestBody CommentDto comment) {
        commentService.addCommentToPost(postId, comment);
    }

    //localhost:8080/api/v1/users/1/posts/1/comments/1
    @GetMapping("/users/{user_id}/posts/{post_id}/comments/{comment_id}")
    @Override
    public CommentEntity getCommentOfPostOfUser(@PathVariable("user_id") long userId,
                                                @PathVariable("post_id") long postId,
                                                @PathVariable("comment_id") long commentId) {
        return commentService.getCommentOfPostOfUser(userId, postId, commentId);
    }

}
