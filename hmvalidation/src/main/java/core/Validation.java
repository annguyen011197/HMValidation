package core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import core.annotation.ProcessAnnotation;
import core.process.FactoryProcess;
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
                FactoryProcess.register();
            }
            return instance;
        }
    }

    public void runObserver(Object object,ResultObserver observer) {
        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            boolean isFailed = false;
            Annotation[] annotations = ProcessAnnotation.process(field.getAnnotations());

            for (Annotation annotation : annotations) {
                IProcess iProcess = FactoryProcess.build(annotation);
                boolean isResult = iProcess.process(annotation, object, field);

                if(!isResult){
                    observer.update(new Result(field.getName(), iProcess.getMessage(annotation)));
                    isFailed = true;
                }
            }

            if(!isFailed){
                observer.update(new Result(field.getName()));
            }
        }
    }
}
