package hmvalidation.core.annotation;

import hmvalidation.core.base.LimitValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface  Limit {
    Class type = LimitValidation.class;
    String message() default  "";
    String target() default "$";
    double min() default Double.NEGATIVE_INFINITY;
    double max() default Double.POSITIVE_INFINITY;
}