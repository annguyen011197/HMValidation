package hmvalidation.core.process;

import hmvalidation.core.base.AbstractValidation;
import hmvalidation.core.base.RegexValidation;
import hmvalidation.core.annotation.Regex;

public class RegexProcess extends IProcess<Regex> {

    @Override
    public Class getClass(Regex annotation) {
        return annotation.type;
    }

    @Override
    public String getMessage(Regex annotation) {
        return annotation.message();
    }

    @Override
    public String getTarget(Regex annotation) {
        return annotation.target();
    }

    @Override
    protected AbstractValidation initValidation(Regex annotation, AbstractValidation abstractValidation) {
        RegexValidation regexValidation = (RegexValidation) abstractValidation;
        regexValidation.setRegex( annotation.regex());
        return regexValidation;
    }
}
