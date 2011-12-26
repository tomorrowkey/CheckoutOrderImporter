
package jp.tomorrowkey.checkoutorderimporter.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DBQueryUtil {

    public static String createInsertQuery(Class<?> clazz) {
        if (clazz == null)
            throw new IllegalArgumentException();

        Field[] fields = clazz.getDeclaredFields();

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ");
        builder.append(StringUtil.camelCaseToSnakeCase(clazz.getSimpleName()));
        builder.append("(");
        for (int i = 0; i < fields.length; i++) {
            if (i > 0)
                builder.append(",");

            builder.append(StringUtil.camelCaseToSnakeCase(fields[i].getName()));
        }
        builder.append(") VALUES(");
        for (int i = 0; i < fields.length; i++) {
            if (i > 0)
                builder.append(",");

            builder.append("?");
        }
        builder.append(");");
        return builder.toString();
    }

    public static Object[] createInsertQueryParameter(Object obj) {
        if (obj == null)
            throw new IllegalArgumentException();

        try {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            Object[] parameters = new Object[fields.length];

            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                StringBuilder methodBuilder = new StringBuilder();
                if (field.getGenericType() == boolean.class) {
                    methodBuilder.append("is");
                } else {
                    methodBuilder.append("get");
                }
                String fieldName = field.getName();
                methodBuilder.append(fieldName.substring(0, 1).toUpperCase());
                methodBuilder.append(fieldName.subSequence(1, fieldName.length()));

                Method method = clazz.getMethod(methodBuilder.toString());
                Object value = method.invoke(obj);
                parameters[i] = value;
            }

            return parameters;
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
