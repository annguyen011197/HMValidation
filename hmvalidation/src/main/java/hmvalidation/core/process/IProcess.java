package hmvalidation.core.process;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import hmvalidation.core.base.AbstractValidation;

public abstract class IProcess<T extends Annotation> {

    public abstract Class getClass(T annotation);
    public abstract String getMessage(T annotation);
    public abstract String getTarget(T annotation);
    protected abstract AbstractValidation initValidation(T annotation, AbstractValidation abstractValidation);

    public boolean process(T annotation, Object object, Field field){
        Class ruleClass = getClass(annotation);
        try {
            Object newValidation = ruleClass.getConstructor().newInstance();
            if (newValidation instanceof AbstractValidation) {
                AbstractValidation abstractValidation = initValidation(annotation, (AbstractValidation) newValidation);
                return abstractValidation.validation(object, field, getTarget(annotation));
            }
            return false;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        }
    }
}
