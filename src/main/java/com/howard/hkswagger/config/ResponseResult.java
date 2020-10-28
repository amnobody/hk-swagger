package com.howard.hkswagger.config;

import java.lang.annotation.*;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/21
 * @description 表明某个类或者方法需要对返回值进行处理
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseResult {
}
