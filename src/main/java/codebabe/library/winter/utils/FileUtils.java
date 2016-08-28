package codebabe.library.winter.utils;

import codebabe.library.winter.factory.ClzStreamLoader;

import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Set;

/**
 * author: code.babe
 * date: 2016-08-26 11:00
 */
public class FileUtils {

    private FileUtils() {}

    /**
     *
     * @param absoluteDirPath
     * @return
     */
    public static Set<File> listAllFiles(String absoluteDirPath) {
        Set<File> returns = new HashSet<File>();
        return getAllFiles(absoluteDirPath, returns);
    }

    /**
     *
     * @param absoluteDirPath
     * @param files temp file, contains all files
     * @return if do not have file under param, return empty list, <p>do not return null, avoid nullPointerException</p>
     */
    private static Set<File> getAllFiles(String absoluteDirPath, Set<File> files) {
        File dir = new File(absoluteDirPath);
        // exist, return files
        if (!dir.exists() && !dir.isDirectory()) {
            return files;
        } else {
            File[] retFiles = dir.listFiles(new ClassFilter());
            for (File item : retFiles) {
                if (item.exists() && item.isFile()) {
                    files.add(item);
                } else {
                    return getAllFiles(item.getAbsolutePath(), files);
                }
            }
        }
        return files;
    }


    protected static class ClassFilter implements FileFilter {

        // filter class by suffix end with ".class"
        public boolean accept(File pathname) {
            String path = pathname.getAbsolutePath();
            return StringUtils.endWith(path, ClzStreamLoader.Param.CLZ_SUFFIX);
        }
    }

}
