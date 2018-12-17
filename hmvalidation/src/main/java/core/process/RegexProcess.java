package core.process;

import core.annotation.Regex;
import core.base.AbstractValidation;
import core.base.RegexValidation;

public class RegexProcess extends IProcess<Regex> {

    @Override
    public Class getClass(Regex annotation) {
        return annotation.type;
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
