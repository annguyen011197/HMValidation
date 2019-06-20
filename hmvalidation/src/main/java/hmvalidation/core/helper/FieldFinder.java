package hmvalidation.core.helper;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldFinder {
    private static FieldFinder instance = null;
    public static FieldFinder getInstance(){
        if(instance == null){
            instance = new FieldFinder();
        }
        return instance;
    }
    public Object find(String path, Object src){
        if(src == null) return null;
        String[] fieldsNames = path.split("\\.");
        Class<?> targetClass = src.getClass();
        for(String fieldName: fieldsNames){
            try {
                Matcher matcher = isArray(fieldName);
                if(matcher.matches()){
                    int position = Integer.valueOf(matcher.group(2));
                    src = getFieldArrayValue(src, position);
                    targetClass = src.getClass();
                } else {
                    Field field = getFieldByName(targetClass,fieldName);
                    targetClass = field.getType();
                    src = getFieldValue(src,field);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return src;
    }

    private Matcher isArray(String fieldName){
        String regex = "(.*.)\\[(\\d)]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fieldName);
        return matcher;
    }

    private Field getFieldByNameArray(Class<?> targetClass, String fieldName)
            throws Exception {
        return targetClass.getDeclaredField(fieldName);
    }

    private Field getFieldByName(Class<?> targetClass, String fieldName)
            throws Exception {
        return targetClass.getDeclaredField(fieldName);
    }

    private Object getFieldValue(Object obj, Field field) throws Exception {
        field.setAccessible(true);
        return field.get(obj);
    }

    private Object getFieldArrayValue(Object obj, int position) {
        if(obj instanceof List){
            try{
                return ((List) obj).get(position);
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }
}
