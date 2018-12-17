package core.process;

import core.annotation.Size;
import core.base.AbstractValidation;
import core.base.SizeValidation;

public class SizeProcess extends IProcess<Size> {

    @Override
    public Class getClass(Size annotation) {
        return annotation.type;
    }

    @Override
    protected AbstractValidation initValidation(Size annotation, AbstractValidation abstractValidation) {
        SizeValidation sizeValidation = (SizeValidation) abstractValidation;
        sizeValidation.setMinSize( annotation.min());
        sizeValidation.setMaxSize( annotation.max());
        return sizeValidation;
    }
}