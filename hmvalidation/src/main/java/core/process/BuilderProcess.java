package core.process;

import java.lang.annotation.Annotation;

import core.annotation.BaseRuleAnnotation;
import core.annotation.RegexRuleAnnotation;
import core.base.RegexValidation;

public class BuilderProcess {

    static public IProcess build(Annotation annotation){
        if(annotation instanceof BaseRuleAnnotation){
            return new BaseProcess();
        }else  if(annotation instanceof RegexRuleAnnotation){
            return new RegexProcess();
        }
        return null;
    }


}
