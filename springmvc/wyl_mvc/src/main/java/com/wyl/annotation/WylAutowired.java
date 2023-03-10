package com.wyl.annotation;

import java.lang.annotation.*;

/**
 * @auther yanl.wang
 * @date 2023/2/3
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WylAutowired {
    String value() default "";
}
