package zh.xyz.tools.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author iccry.zeng
 * @Description 日志注解
 * @Date Create in 2024/3/31 15:58
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {

    /**
     * 日志等级
     */
    int level() default 0;

    /**
     * 描述
     */
    String description() default "";

    /**
     * 类型
     */
    String type() default "none";
}
