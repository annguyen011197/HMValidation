package core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import core.base.MaxDoubleValidation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxDouble {
    Class type = MaxDoubleValidation.class;
    double max() default 0;
    String message() default "";
    String target() default "$";
}


