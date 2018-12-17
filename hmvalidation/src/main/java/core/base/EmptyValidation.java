package core.base;

import java.util.Collection;
import java.util.Map;

public class EmptyValidation extends AbstractValidation{
    @Override
    public boolean validation(Object object) {
        if(object instanceof String){
            return !object.equals("");
        } else if(object instanceof Collection){
            return ((Collection) object).size() != 0;
        } else if(object instanceof Map){
            return ((Map) object).size() != 0;
        }
        return false ;
    }
}
