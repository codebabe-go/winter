package codebabe.library.winter.utils;

/**
 * author: code.babe
 * date: 2016-08-26 12:49
 */
public class PathUtils {

    private PathUtils() {}

    public static String subPath(String path, String separator) {
        if (!StringUtils.isNotEmpty(path) || !StringUtils.isNotEmpty(separator)) {
            return StringUtils.Param.EMPTY_STRING;
        }
        return path.substring(KMP.kmp(path, separator));
    }

}
