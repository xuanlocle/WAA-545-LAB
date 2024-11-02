package miu.waa.xuanloc.lab1.waalab1.repository;

import miu.waa.xuanloc.lab1.waalab1.entity.ExceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepository extends JpaRepository<ExceptionEntity, Long> {
}
