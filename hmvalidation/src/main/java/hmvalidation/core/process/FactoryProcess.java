package hmvalidation.core.process;

import hmvalidation.core.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


public class FactoryProcess {

    private static HashMap<String, Class> hashMap = new HashMap<>();


    public static void register(){
        hashMap.put(Regex.class.getSimpleName(), RegexProcess.class);
        hashMap.put(NotNull.class.getSimpleName(), NotNullProcess.class);
        hashMap.put(NotEmpty.class.getSimpleName(), NotEmptyProcess.class);
        hashMap.put(Size.class.getSimpleName(), SizeProcess.class);
        hashMap.put(Limit.class.getSimpleName(),LimitProcess.class);
        hashMap.put(MaxDouble.class.getSimpleName(), MaxDoubleProcess.class);
        hashMap.put(MinDouble.class.getSimpleName(), MinDoubleProcess.class);
        hashMap.put(ContainArrayString.class.getSimpleName(), ContainArrayStringProcess.class);
    }

    public static void register(Class annotation, Class cl){
        hashMap.put(annotation.getSimpleName(), cl);
    }

    static public IProcess<Annotation> build(Annotation annotation){
        Class clazz = hashMap.get(annotation.annotationType().getSimpleName());
        if(clazz == null) return null;
        try {
            return (IProcess<Annotation>) clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
