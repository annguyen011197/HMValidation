package hmvalidation.core.annotation;

import hmvalidation.core.base.ContainArrayStringValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface  ContainArrayString {
    Class type = ContainArrayStringValidation.class;
    String message() default  "";
    String target() default "$";
    String[] array() default {};
}
