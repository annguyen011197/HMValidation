package core.base;

import java.lang.reflect.Field;

public abstract class AbstractValidation {
    public boolean validation(Object object, Field field){
        try {
            Object result = field.get(object);
            return validation(result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
    protected abstract boolean validation(Object object);
}

