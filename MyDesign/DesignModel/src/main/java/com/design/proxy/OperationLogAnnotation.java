package com.design.proxy;

import java.lang.annotation.*;

/**
 * @author yuanyuan
 * @version V1.0
 * @Description 动态代理注解
 */
@Target(ElementType.METHOD)//注解放置的目标位置即方法级别
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
@Documented
public @interface OperationLogAnnotation {
    String operModul() default ""; // 操作模块

    String operType() default "";  // 操作类型

    String operDesc() default "";  // 操作说明
}