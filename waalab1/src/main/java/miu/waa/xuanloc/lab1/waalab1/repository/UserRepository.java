package miu.waa.xuanloc.lab1.waalab1.repository;

import miu.waa.xuanloc.lab1.waalab1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByPostsIsNotEmpty();

    @Query("SELECT u FROM users u WHERE SIZE(u.posts) > :minPost")
    List<UserEntity> findAllByPostsIsGreaterThan(int minPost);

    @Query("SELECT u FROM users u INNER JOIN u.posts posts " +
            "WHERE UPPER(posts.title) = UPPER(:title)")
    List<UserEntity> findAllByPostsTitleIgnoreCase(String title);
}
