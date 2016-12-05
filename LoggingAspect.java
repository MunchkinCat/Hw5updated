package com.example;

/**
 * Created by Gabe on 12/2/2016.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.example..*( .. ))") //&& args(question,answer)) //@Pointcut("execution(public * com.example..*(..))")
    public void publicMethod(){}

    @Before("publicMethod()&& @annotation(Timed)")
    public void addLog( final JoinPoint joinPoint){
    System.out.println("*** Executing: "+ joinPoint.getSignature());
    Object[] arguments = joinPoint.getArgs();       ///get [0]?
        for(Object argument : arguments){
            System.out.println("*** "+ argument.getClass().getSimpleName()+ " = "+ argument);

        }
    }
}
