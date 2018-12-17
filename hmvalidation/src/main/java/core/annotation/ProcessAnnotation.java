package core.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Deprecated
/**
 * Hiện tại chưa support nhìu annotation giống nhau
 * */
public class ProcessAnnotation {

    private static HashMap<Class, BuilderAnnotations> hashMap = new HashMap<>();

    public static void register(){
        //hashMap.put(BaseRuleAnnotations.class, annotation -> ((BaseRuleAnnotations)annotation).value());
    }

    public static void register(Class cl, BuilderAnnotations builderAnnotations){
        hashMap.put(cl, builderAnnotations);
    }

    public static Annotation[] process(Annotation[] array){
        List<Annotation> list = new ArrayList<>();
        for (Annotation annotation : array) {
            list.addAll(Arrays.asList(getAnnotations(annotation)));
        }
        return list.toArray(new Annotation[0]);
    }


    private static Annotation[] getAnnotations(Annotation annotation){
        if(hashMap.containsKey(annotation.annotationType())){
            return hashMap.get(annotation.annotationType()).annotations(annotation);
        }
        return new Annotation[]{annotation};
    }

    public interface BuilderAnnotations{
        Annotation[] annotations(Annotation annotation);
    }
}


