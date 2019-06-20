package hmvalidation.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import hmvalidation.core.annotation.ProcessAnnotation;
import hmvalidation.core.process.FactoryProcess;
import hmvalidation.core.process.IProcess;
import hmvalidation.core.result.Result;
import hmvalidation.core.result.ResultObserver;

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
        List<Result> results = new ArrayList<>();
        for (Field field : fields) {
            boolean isFailed = false;
            field.setAccessible(true);
            Annotation[] annotations = field.getAnnotations();

            for (Annotation annotation : annotations) {
                IProcess iProcess = FactoryProcess.build(annotation);
                if(iProcess == null) continue;
                boolean isResult = iProcess.process(annotation, object, field);
                if(!isResult){
                    results.add(new Result(field.getName(), iProcess.getMessage(annotation)));
                    isFailed = true;
                }
            }

            if(!isFailed){
                results.add(new Result(field.getName()));
            }
        }

        observer.update(results);
    }

    public void runObserver(IValidation object){
        long startTime = System.currentTimeMillis();
        this.runObserver(object,object.getValidation());
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
