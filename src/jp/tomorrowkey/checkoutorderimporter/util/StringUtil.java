
package jp.tomorrowkey.checkoutorderimporter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    /**
     * 文字列が、nullもしくは空なのか判定します
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * キャメルケースからスネークケースに変換します
     * 
     * @param str
     * @return
     */
    public static String camelCaseToSnakeCase(String str) {
        if (str == null)
            throw new IllegalArgumentException();

        Pattern pattern = Pattern
                .compile("(^[a-z][a-z0-9]*|[A-Z](?:[A-Z]*(?=$|[A-Z][a-z0-9])|[a-z0-9]*))");
        Matcher matcher = pattern.matcher(str);

        StringBuilder buffer = new StringBuilder();
        boolean isFirst = true;
        while (matcher.find()) {
            if (isFirst) {
                isFirst = false;
            } else {
                buffer.append("_");
            }
            buffer.append(str.substring(matcher.start(), matcher.end()));
        }

        return buffer.toString().toUpperCase();
    }
}
