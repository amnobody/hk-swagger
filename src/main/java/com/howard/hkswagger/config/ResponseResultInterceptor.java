package com.howard.hkswagger.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/21
 * @description
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ResponseResultInterceptor.class);

    /**
     * 需要处理的标记
     */
    public final static String NEED_RESOLVE = "wrapper_response";



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("拦截请求：handler的class类型=[{}]", handler.getClass());
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();

            if (clazz.isAnnotationPresent(ResponseResult.class) || method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(NEED_RESOLVE, clazz.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
