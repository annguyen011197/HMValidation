package hmvalidation.core.process;

import hmvalidation.core.base.AbstractValidation;
import hmvalidation.core.base.LimitValidation;
import hmvalidation.core.annotation.Limit;

public class LimitProcess extends IProcess<Limit> {
    @Override
    public Class getClass(Limit annotation) {
        return annotation.type;
    }

    @Override
    public String getMessage(Limit annotation) {
        return annotation.message();
    }

    @Override
    public String getTarget(Limit annotation) {
        return annotation.target();
    }

    @Override
    protected AbstractValidation initValidation(Limit annotation, AbstractValidation abstractValidation) {
        LimitValidation limitValidation = (LimitValidation) abstractValidation;
        limitValidation.setMax(annotation.max());
        limitValidation.setMin(annotation.min());
        return limitValidation;
    }
}
