package codebabe.library.winter.utils;

/**
 * author: code.babe
 * date: 2016-08-26 10:43
 */
public class StringUtils {

    public interface Param {
        String EMPTY_STRING = "";
    }

    public static boolean isNotEmpty(String str) {
        return null != str && !"".equals(str);
    }

    public static boolean endWith(String str, String suffix) {
        if (!isNotEmpty(str) && !isNotEmpty(suffix)) {
            return false;
        }
        return str.endsWith(suffix);
    }

    public static String subString(String str, String separator) {
        if (!isNotEmpty(str)) {
            return Param.EMPTY_STRING;
        }
        int index = str.lastIndexOf(separator);
        return str.substring(index + 1);
    }

}
