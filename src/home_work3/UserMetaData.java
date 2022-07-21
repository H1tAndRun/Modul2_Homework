package home_work3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserMetaData {
    @GetMetaData
    private String name;
    private int count;

    public UserMetaData(String name, int count){
        this.name = name;
        this.count = count;
        checkAnnotation(this);
    }

   public void GetSuperName(String prefix){
       System.out.println(prefix);

   }
    private static void checkAnnotation(UserMetaData userMetaData){
        try {
            Class clazz = userMetaData.getClass();
            Field[] field = clazz.getDeclaredFields();
            Method method = clazz.getMethod("GetSuperName", String.class);

            if (clazz.isAnnotationPresent(GetMetaData.class)) {
                for (Field declaredField : clazz.getDeclaredFields()) {
                    declaredField.setAccessible(true);
                    System.out.println(declaredField.get(userMetaData));
                }
            }
            for (Field field1 : field) {
                if (field1.isAnnotationPresent(GetMetaData.class)) {
                    field1.setAccessible(true);
                    System.out.println(field1.get(userMetaData));
                }
            }

            if (method.isAnnotationPresent(GetMetaData.class)) {
                long start = System.currentTimeMillis();
                long end = System.currentTimeMillis();
                System.out.print("Time is run method = " + (double) (start - end));
            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }
}
