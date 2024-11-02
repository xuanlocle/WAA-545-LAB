package miu.waa.xuanloc.lab1.waalab1.aspect;

import miu.waa.xuanloc.lab1.waalab1.entity.LoggerEntity;
import miu.waa.xuanloc.lab1.waalab1.repository.LogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private LogRepository logRepository;

    @After("execution(* miu.waa.xuanloc.lab1.waalab1.controller..*(..)) " +
            "|| execution(* miu.waa.xuanloc.lab1.waalab1.service..*(..)) ")
    public void logMe(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String operation = "Executed method: " + className + "." + methodName;
        System.out.println(operation);
        LoggerEntity newLog = new LoggerEntity();
        newLog.setOperation(operation);
        newLog.setPrinciple("Guest");
        newLog.setDate(LocalDate.now());
        newLog.setTime(LocalTime.now());
        logRepository.save(newLog);
    }


}
