package hmvalidation.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import hmvalidation.core.base.MinDoubleValidation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MinDouble {
    Class type = MinDoubleValidation.class;
    double min() default 0;
    String message() default "";
    String target() default "$";
}


