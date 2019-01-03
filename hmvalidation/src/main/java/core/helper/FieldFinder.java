package core.helper;

import java.lang.reflect.Field;

public class FieldFinder {
    private static  FieldFinder instance = null;
    public static FieldFinder getInstance(){
        if(instance == null){
            instance = new FieldFinder();
        }
        return instance;
    }
    public Object find(String path, Object src){
        if(src == null) return src;
        String[] fieldsNames = path.split("\\.");
        Class<?> targetClass = src.getClass();
        for(String fieldName: fieldsNames){
            try {
                Field field =  getFieldByName(targetClass,fieldName);
                targetClass = field.getType();
                src = getFieldValue(src,field);
            } catch (Exception e) {
                e.printStackTrace();
                return src;
            }
        }
        return src;
    }

    private Field getFieldByName(Class<?> targetClass, String fieldName)
            throws Exception {
        return targetClass.getDeclaredField(fieldName);
    }

    private Object getFieldValue(Object obj, Field field) throws Exception {
        field.setAccessible(true);
        return field.get(obj);
    }
}
