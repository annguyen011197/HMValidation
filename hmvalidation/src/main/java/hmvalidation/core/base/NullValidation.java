package hmvalidation.core.base;

public class NullValidation extends AbstractValidation
{
    @Override
    public boolean validation(Object object) {
        return object != null;
    }
}
