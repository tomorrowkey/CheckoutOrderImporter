
package jp.tomorrowkey.checkoutorderimporter.util;

import java.lang.reflect.Field;

public class ReflectionUtil {

    public static String getterName(Field field) {
        if (field == null)
            throw new IllegalArgumentException("field is null");

        StringBuilder builder = new StringBuilder();
        if (field.getGenericType() == boolean.class) {
            builder.append("is");
        } else {
            builder.append("get");
        }
        String fieldName = field.getName();
        builder.append(fieldName.substring(0, 1).toUpperCase());
        builder.append(fieldName.substring(1, fieldName.length()));
        return builder.toString();
    }

}
