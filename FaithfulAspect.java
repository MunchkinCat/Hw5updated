package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Gabe on 12/2/2016.
 */
@Component
@Aspect
public class FaithfulAspect {
    @Pointcut("execution(public * com.example..*( .. ))")
    public void allMethods(){}

    public void MethodName(){
        System.out.println("Giving Praise");
    }

    public void Pray(){
        System.out.println("Praying");
    }

    @Before("allMethods() && @annotation(DoAction)")
    public void pray(final JoinPoint joinPoint){
        Pray();
    }

    @After("allMethods() && @annotation(DoAction)")
    public void givePraise(final JoinPoint joinPoint){
        MethodName();
    }
}
