package hmvalidation.core.process;

import hmvalidation.core.annotation.ContainArrayString;
import hmvalidation.core.base.AbstractValidation;
import hmvalidation.core.base.ContainArrayStringValidation;

public class ContainArrayStringProcess extends IProcess<ContainArrayString> {
    @Override
    public Class getClass(ContainArrayString annotation) {
        return annotation.type;
    }

    @Override
    public String getMessage(ContainArrayString annotation) {
        return annotation.message();
    }

    @Override
    public String getTarget(ContainArrayString annotation) {
        return annotation.target();
    }

    @Override
    protected AbstractValidation initValidation(ContainArrayString annotation, AbstractValidation abstractValidation) {
        ContainArrayStringValidation validation = (ContainArrayStringValidation) abstractValidation;
        validation.setValue(annotation.array());
        return validation;
    }
}
