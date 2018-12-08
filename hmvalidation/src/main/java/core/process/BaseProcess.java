package core.process;

import core.annotation.BaseRuleAnnotation;
import core.base.AbstractValidation;


public class BaseProcess extends IProcess<BaseRuleAnnotation> {

    @Override
    public Class getClass(BaseRuleAnnotation annotation) {
        return annotation.type();
    }

    @Override
    protected AbstractValidation initValidation(BaseRuleAnnotation annotation, AbstractValidation abstractValidation) {
        return abstractValidation;
    }
}
