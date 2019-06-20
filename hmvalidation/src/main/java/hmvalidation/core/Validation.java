package hmvalidation.core;

import hmvalidation.core.annotation.ProcessAnnotation;
import hmvalidation.core.process.FactoryProcess;
import hmvalidation.core.process.IProcess;
import hmvalidation.core.result.Result;
import hmvalidation.core.result.ResultObserver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

    public void runObserver(Object object,ResultObserver observer){
        runObserver(object, observer, "$");
    }

    private void runObserver(Object object,ResultObserver observer, String parent) {
        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        List<Result> results = new ArrayList<>();
        for (Field field : fields) {
            boolean isFailed = false;
            field.setAccessible(true);
            Annotation[] annotations = field.getAnnotations();

            for (Annotation annotation : annotations) {

                IProcess<Annotation> iProcess = FactoryProcess.build(annotation);
                if(iProcess == null) continue;

                boolean isResult = iProcess.process(annotation, object, field);
                if(!isResult){
                    Result result = createResult(iProcess, annotation, parent + "." + field.getName());
                    results.add(result);
                    isFailed = true;
                }

            }

            String target = parent + "." + field.getName();

            if(!isFailed){
                results.add(new Result(target));
            }

            //Run validation of field
            runChild(field, object, results::addAll, target);
        }

        observer.update(results);
    }

    private Result createResult(IProcess<Annotation> iProcess, Annotation annotation, String msg){
        String target = iProcess.getTarget(annotation);
        if(target == null || target.equals("$")){
            target = msg;
        }
        String message = iProcess.getMessage(annotation);
        if(message == null || message.equals("")) message = annotation.annotationType().getSimpleName();
        return new Result(target, message);
    }

    private void runChild(Field field, Object object, ResultObserver observer, String target){
        try {
            Object tryParse = field.get(object);
            if(tryParse instanceof IValidation){
                IValidation validation = (IValidation) tryParse;
                runObserver(validation, observer, target);
            }else if(tryParse instanceof List){
                int index = 0;
                for (Object item : (List)tryParse){
                    if(item instanceof IValidation){
                        IValidation validation = (IValidation) item;
                        runObserver(validation, observer, target +"[" + index + "]");
                    }
                    index++;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void runObserver(IValidation object){
        long startTime = System.currentTimeMillis();
        this.runObserver(object,object.getValidation());
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
