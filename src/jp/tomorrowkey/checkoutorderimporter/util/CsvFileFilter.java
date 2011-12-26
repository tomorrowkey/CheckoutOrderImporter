
package jp.tomorrowkey.checkoutorderimporter.util;

import java.io.File;
import java.io.FileFilter;

public class CsvFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        if (file.isDirectory())
            return false;
        String fileName = file.getName();
        return fileName.endsWith(".csv");
    }

}
