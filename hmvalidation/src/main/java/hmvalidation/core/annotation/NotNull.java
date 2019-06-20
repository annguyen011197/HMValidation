package hmvalidation.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import hmvalidation.core.base.NullValidation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {
    Class type = NullValidation.class;
    String message() default "";
    String target() default "$";
}




