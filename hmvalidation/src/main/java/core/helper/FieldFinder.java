package core.helper;

import java.lang.reflect.Field;

public class FieldFinder {
    public static Object find(String path, Object src){
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

    private static Field getFieldByName(Class<?> targetClass, String fieldName)
            throws Exception {
        return targetClass.getDeclaredField(fieldName);
    }

    private static Object getFieldValue(Object obj, Field field) throws Exception {
        field.setAccessible(true);
        return field.get(obj);
    }
}
