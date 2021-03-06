package hmvalidation.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import hmvalidation.core.base.SizeValidation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Size {
    Class type = SizeValidation.class;
    int min() default 0;
    int max() default Integer.MAX_VALUE;
    String message() default "";
    String target() default "$";
}
