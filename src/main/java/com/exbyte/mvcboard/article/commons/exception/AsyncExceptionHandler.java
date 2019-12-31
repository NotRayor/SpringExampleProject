package com.exbyte.mvcboard.article.commons.exception;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        System.out.println("==============>>>>>>>>>>>> THREAD ERROR");
        System.out.println("Exception Message :: " + throwable.getMessage());
        System.out.println("Method Name :: " + method.getName());
        for (Object param : objects) {
            System.out.println("Parameter Value :: " + param);
        }

        // JOB_LOG : 종료 입력
        // ...
        System.out.println("==============>>>>>>>>>>>> THREAD ERROR END");
    }
}
