package core.process;


import core.annotation.MaxDouble;
import core.base.AbstractValidation;
import core.base.MaxDoubleValidation;

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
