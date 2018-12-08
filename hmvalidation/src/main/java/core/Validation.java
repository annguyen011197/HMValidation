package core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import core.annotation.BaseRuleAnnotation;
import core.annotation.ProcessAnnotation;
import core.base.AbstractValidation;
import core.process.BuilderProcess;
import core.process.IProcess;
import core.result.Result;
import core.result.ResultObserver;

public class Validation {
    private static Validation instance;
    private static final Object lock = new Object();
    private Validation(){}

    public static Validation getInstance(){
        synchronized (lock){
            if(instance == null){
                instance = new Validation();
                ProcessAnnotation.register();
            }
            return instance;
        }
    }

    public void runObserver(Object object,ResultObserver observer) {
        Class aClass = object.getClass();
        Field[] fields = aClass.getFields();

        for (Field field : fields) {
            boolean isFailed = false;
            Annotation[] annotations = ProcessAnnotation.process(field.getAnnotations());

            for (Annotation annotation : annotations) {
                IProcess iProcess = BuilderProcess.build(annotation);
                boolean isResult = iProcess.process(annotation, object, field);

                if(!isResult){
                    observer.update(new Result(field.getName(), iProcess.getClass(annotation).getSimpleName()));
                    isFailed = true;
                }
            }

            if(!isFailed){
                observer.update(new Result(field.getName()));
            }
        }
    }
}
