package com.jxxt.common.annotation;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导入模板
 * 
 * @author hqsun
 * @since 2016年12月23日
 *
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Template {

    /**
     * 映射名称
     *
     * @author hqsun
     * @return
     * @since 2016年12月23日
     */
    String value() default "";

    /**
     * 日期格式
     *
     * @author hqsun
     * @return
     * @since 2017年1月12日
     */
    String dateFormate() default "yyyy/MM/dd";
}
