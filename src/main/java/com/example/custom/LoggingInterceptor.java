package com.example.custom;

import io.micronaut.aop.InterceptorBinding;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.annotation.Nullable;
import jakarta.inject.Singleton;

@Singleton
@InterceptorBinding(LogExecution.class)
public class LoggingInterceptor implements MethodInterceptor<Object, Object> {
    @Override
    public @Nullable Object intercept(MethodInvocationContext<Object, Object> context) {
        System.out.println("Before:"  + context.getMethodName() + " execution");
        Object result = context.proceed();
        System.out.println("After: " + context.getMethodName() + " completion");
        return result;
    }
}
