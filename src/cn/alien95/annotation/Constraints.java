package cn.alien95.annotation;

/**
 * Created by llxal on 2015/11/23.
 */
public @interface Constraints {
    boolean primaryKey() default false;
    boolean allowNull() default false;
    boolean unique() default false;
}
