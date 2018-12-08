package core.base;

public class EmptyValidation extends AbstractValidation{
    @Override
    public boolean validation(Object object) {
        if(object instanceof String){
            return !object.equals("");
        }
        return false;
    }
}
