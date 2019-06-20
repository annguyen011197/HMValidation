package hmvalidation.core.process;

import hmvalidation.core.base.AbstractValidation;
import hmvalidation.core.annotation.NotEmpty;

public class NotEmptyProcess extends IProcess<NotEmpty> {

    @Override
    public Class getClass(NotEmpty annotation) {
        return annotation.type;
    }

    @Override
    public String getMessage(NotEmpty annotation) {
        return annotation.message();
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