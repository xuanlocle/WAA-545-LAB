package miu.waa.xuanloc.lab1.waalab1.repository;

import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface  PostJpaRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAllByAuthor(String author);

    List<PostEntity> findAllByAuthorContains(String authorContain);

    List<PostEntity> findAllByTitleIgnoreCase(String title);

    Optional<PostEntity> findByIdAndUserId(long postId, long userId);
}
