package miu.waa.xuanloc.lab1.waalab1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionAspect {
    @Around("@annotation(miu.waa.xuanloc.lab1.waalab1.aspect.annotation.ExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
//        System.out.println("BEFORE Log around:" + methodName);
        Object result = joinPoint.proceed();
//        System.out.println("AFTER Log around:" + methodName);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Execution " + methodName + " in : " + duration + " ms");

        return result;
    }
}
