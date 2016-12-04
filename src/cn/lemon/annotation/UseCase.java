package cn.alien95.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by llxal on 2015/11/22.
 */

@Target(ElementType.METHOD)   //应用的地方：目标是方法
@Retention(RetentionPolicy.RUNTIME)   //在运行时可用，有SOURCE(源代码)，CLASS（类文件中）,RUNTIME(运行时 )
public @interface UseCase {

    //定义两个元素
    public int id() default 0;
    public String description() default "cao";
}
