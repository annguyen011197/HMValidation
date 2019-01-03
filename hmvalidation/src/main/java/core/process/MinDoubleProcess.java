package core.process;


import core.annotation.MinDouble;
import core.base.AbstractValidation;
import core.base.MinDoubleValidation;

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
