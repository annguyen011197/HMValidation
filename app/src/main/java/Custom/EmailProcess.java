package Custom;

import core.base.AbstractValidation;
import core.process.IProcess;

public class EmailProcess extends IProcess<Email> {
    @Override
    public Class getClass(Email annotation) {
        return annotation.type;
    }

    @Override
    public String getMessage(Email annotation) {
        return annotation.message();
    }

    @Override
    public String getTarget(Email annotation) {
        return annotation.target();
    }

    @Override
    protected AbstractValidation initValidation(Email annotation, AbstractValidation abstractValidation) {
        return abstractValidation;
    }
}
