package miu.waa.xuanloc.lab1.waalab1.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import miu.waa.xuanloc.lab1.waalab1.entity.CommentEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.UserEntity;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.CommentDto;
import miu.waa.xuanloc.lab1.waalab1.repository.CommentRepository;
import miu.waa.xuanloc.lab1.waalab1.repository.PostJpaRepository;
import miu.waa.xuanloc.lab1.waalab1.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final PostJpaRepository postJpaRepository;
    private final CommentRepository commentRepository;

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public void addCommentToPost(long postId, CommentDto comment) {
        postJpaRepository.findById(postId).ifPresent(post -> {
            final CommentEntity commentToSave = modelMapper.map(comment, CommentEntity.class);
            commentToSave.setPost(post);
            commentRepository.save(commentToSave);
        });
    }

    @Override
    public CommentEntity getCommentOfPostOfUser(long userId, long postId, long commentId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User not found with id: " + userId);
        }

        PostEntity post = postJpaRepository.findByIdAndUserId(postId, userId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + postId + " for user with id: " + userId));

        return commentRepository.findByIdAndPostId(commentId, post.getId())
                .orElseThrow(() -> new EntityNotFoundException("Comment not found with id: " + commentId + " for post with id: " + postId));
    }
}
