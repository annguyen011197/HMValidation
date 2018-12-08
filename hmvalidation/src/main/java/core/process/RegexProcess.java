package core.process;

import core.annotation.RegexRuleAnnotation;
import core.base.AbstractValidation;
import core.base.RegexValidation;

public class RegexProcess extends IProcess<RegexRuleAnnotation> {

    @Override
    public Class getClass(RegexRuleAnnotation annotation) {
        return annotation.type();
    }

    @Override
    protected AbstractValidation initValidation(RegexRuleAnnotation annotation, AbstractValidation abstractValidation) {
        RegexValidation regexValidation = (RegexValidation) abstractValidation;
        regexValidation.setRegex( annotation.regex());
        return regexValidation;
    }
}
