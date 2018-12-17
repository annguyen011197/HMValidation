package core.process;

import core.annotation.NotEmpty;
import core.base.AbstractValidation;

public class NotEmptyProcess extends IProcess<NotEmpty> {

    @Override
    public Class getClass(NotEmpty annotation) {
        return annotation.type;
    }

    @Override
    public String getTarget(NotEmpty annotation) {
        return annotation.target();
    }

    @Override
    protected AbstractValidation initValidation(NotEmpty annotation, AbstractValidation abstractValidation) {
        return abstractValidation;
    }
}