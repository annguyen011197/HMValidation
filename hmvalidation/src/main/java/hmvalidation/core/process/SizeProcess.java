package hmvalidation.core.process;

import hmvalidation.core.base.AbstractValidation;
import hmvalidation.core.base.SizeValidation;
import hmvalidation.core.annotation.Size;

public class SizeProcess extends IProcess<Size> {

    @Override
    public Class getClass(Size annotation) {
        return annotation.type;
    }

    @Override
    public String getMessage(Size annotation) {
        return annotation.message();
    }

    @Override
    public String getTarget(Size annotation) {
        return annotation.target();
    }

    @Override
    protected AbstractValidation initValidation(Size annotation, AbstractValidation abstractValidation) {
        SizeValidation sizeValidation = (SizeValidation) abstractValidation;
        sizeValidation.setMinSize( annotation.min());
        sizeValidation.setMaxSize( annotation.max());
        return sizeValidation;
    }
}