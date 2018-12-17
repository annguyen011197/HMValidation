package core.process;

import core.annotation.NotNull;
import core.base.AbstractValidation;

public class NotNullProcess extends IProcess<NotNull> {

    @Override
    public Class getClass(NotNull annotation) {
        return annotation.type;
    }

    @Override
    public String getTarget(NotNull annotation) {
        return annotation.target();
    }

    @Override
    protected AbstractValidation initValidation(NotNull annotation, AbstractValidation abstractValidation) {
        return abstractValidation;
    }
}