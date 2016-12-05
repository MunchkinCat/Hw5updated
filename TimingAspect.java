package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Gabe on 12/2/2016.
 */
@Component
@Aspect
public class TimingAspect {
    @Pointcut("execution(public * com.example..*( .. ))") //@Pointcut("execution(public * com.example..*(..))")
    public void allMethods(){}

    @Around( "allMethods() && @annotation(Timed)")  //Error -- must only use around
    public Object profile(final ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        try {
            final Object value = joinPoint.proceed();
            return value;
        } catch (Throwable t) {
            throw t;
        }finally{
            final long stop = System.currentTimeMillis();
            System.out.println("+++Execution time of " + joinPoint.getSignature().getName()+
            " was : " + (stop-start));
        }
    }
}
