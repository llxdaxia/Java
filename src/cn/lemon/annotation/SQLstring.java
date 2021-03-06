package cn.alien95.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by llxal on 2015/11/23.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLstring {

    int value() default 0;
    String name() default "";
    Constraints constraints() default @Constraints(primaryKey = false , allowNull = true , unique = true);   //设置默认值


}
