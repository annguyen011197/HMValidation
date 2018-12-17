package core.base;

public class EmptyValidation extends AbstractValidation{
    @Override
    public boolean validation(Object object) {
        return object instanceof String && !object.equals("");
    }
}
