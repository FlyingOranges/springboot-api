package com.vue.api.aspect;

import com.vue.api.utils.RedisUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Aspect
@Component
public class RequestAspect {
    //启用日志
    private final static Logger logger = LoggerFactory.getLogger(RequestAspect.class);

    @Autowired
    private RedisUtils redisUtils;

    @Pointcut("execution(public * com.vue.api.controller.web..*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) throws IOException {
        //进入该控制器，执行方法之前执行
        logger.info("执行方法之前执行");

        //实例化request类 强制转换成object
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //获取本次请求的url
        logger.info("url={}", request.getRequestURL());
        //获取本次请求的method
        logger.info("method={}", request.getMethod());
        //获取客户端发来请求的ip
        logger.info("ip={}", request.getRemoteAddr());

        //获取本次请求目的类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());
        //获取本次请求的参数信息
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("pointcut()")
    public void doAfter() {
        //进入该控制器，完成方法之后执行
        logger.info("执行方法之后执行");
    }

    @AfterReturning(returning = "object", pointcut = "pointcut()")
    public void doAfterReturning(Object object) {
        //获取本次请求的返回结果(完成方法之后执行)
        logger.info("response={}", object.toString());
    }
}
