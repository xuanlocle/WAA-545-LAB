package miu.waa.xuanloc.lab1.waalab1.controller;

import miu.waa.xuanloc.lab1.waalab1.entity.CommentEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.CommentDto;

public interface CommentController {

    void addCommentToPost(long postId, CommentDto comment);

    CommentEntity getCommentOfPostOfUser(long userId, long postId, long commentId);
}
