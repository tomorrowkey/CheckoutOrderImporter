
package jp.tomorrowkey.checkoutorderimporter.util;

import java.io.File;

/**
 * ファイルに関するユーティリティ
 */
public class FileUtil {

    /**
     * 指定されたパスにファイルが存在するか判定します
     * 
     * @param path
     * @return
     */
    public static boolean isExistsFile(String path) {
        File f = new File(path);
        boolean exists = f.exists();
        boolean isFile = !f.isDirectory();
        return exists && isFile;
    }

}
