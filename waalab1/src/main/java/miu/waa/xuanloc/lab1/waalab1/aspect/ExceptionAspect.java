package miu.waa.xuanloc.lab1.waalab1.aspect;

import miu.waa.xuanloc.lab1.waalab1.entity.ExceptionEntity;
import miu.waa.xuanloc.lab1.waalab1.repository.ExceptionRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionAspect {

    @Autowired
    private ExceptionRepository exceptionRepository;

    @AfterThrowing(pointcut = "execution(* miu.waa.xuanloc.lab1.waalab1..*(..))", throwing = "exception")
    public void catchException(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String operation = "Exception in method: " + className + "." + methodName;

        // Create a new exception log entry
        ExceptionEntity exceptionLog = new ExceptionEntity();
        exceptionLog.setOperation(operation);
        exceptionLog.setDate(LocalDate.now());
        exceptionLog.setTime(LocalTime.now());
        exceptionLog.setPrinciple("Guest");
        exceptionLog.setExceptionType(exception.getClass().getName());
        System.out.println("exceptionLog: " + exceptionLog);

        exceptionRepository.save(exceptionLog);

    }

}
