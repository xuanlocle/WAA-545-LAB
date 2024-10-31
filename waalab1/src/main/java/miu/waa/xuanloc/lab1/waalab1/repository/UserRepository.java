package miu.waa.xuanloc.lab1.waalab1.repository;

import miu.waa.xuanloc.lab1.waalab1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByPostsIsNotEmpty();

}
