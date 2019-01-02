package core.base;

import core.helper.FieldFinder;

import java.lang.reflect.Field;

public abstract class AbstractValidation {
    public boolean validation(Object object, Field field, String target){
        try {
            if(target.equals("$")){
                Object result = field.get(object);
                return validation(result);
            }else{
                //Find value from path target
                Object result = FieldFinder.find(target.substring(2),field.get(object));
                return validation(result);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
    protected abstract boolean validation(Object object);
}

