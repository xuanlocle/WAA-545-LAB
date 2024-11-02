package miu.waa.xuanloc.lab1.waalab1.repository;

import miu.waa.xuanloc.lab1.waalab1.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LoggerEntity, Integer> {


}
