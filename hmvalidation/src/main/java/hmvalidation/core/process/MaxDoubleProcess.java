package hmvalidation.core.process;


import hmvalidation.core.base.AbstractValidation;
import hmvalidation.core.base.MaxDoubleValidation;
import hmvalidation.core.annotation.MaxDouble;

public class MaxDoubleProcess extends IProcess<MaxDouble> {

    @Override
    public Class getClass(MaxDouble annotation) {
        return annotation.type;
    }

    @Override
    public String getMessage(MaxDouble annotation) {
        return annotation.message();
    }

    @Override
    public String getTarget(MaxDouble annotation) {
        return annotation.target();
    }

    @Override
    protected AbstractValidation initValidation(MaxDouble annotation, AbstractValidation abstractValidation) {
        MaxDoubleValidation maxDoubleValidation = (MaxDoubleValidation) abstractValidation;
        maxDoubleValidation.setValueCompare( annotation.max());
        return maxDoubleValidation;
    }
}
