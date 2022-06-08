package com.zemoso.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.zemoso.aop.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.zemoso.aop.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.zemoso.aop.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
