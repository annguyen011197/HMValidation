package hmvalidation.core.process;


import hmvalidation.core.base.AbstractValidation;
import hmvalidation.core.base.MinDoubleValidation;
import hmvalidation.core.annotation.MinDouble;

public class MinDoubleProcess extends IProcess<MinDouble> {

    @Override
    public Class getClass(MinDouble annotation) {
        return annotation.type;
    }

    @Override
    public String getMessage(MinDouble annotation) {
        return annotation.message();
    }

    @Override
    public String getTarget(MinDouble annotation) {
        return annotation.target();
    }

    @Override
    protected AbstractValidation initValidation(MinDouble annotation, AbstractValidation abstractValidation) {
        MinDoubleValidation minDoubleValidation = (MinDoubleValidation) abstractValidation;
        minDoubleValidation.setValueCompare( annotation.min());
        return minDoubleValidation;
    }
}
