package codebabe.library.winter.utils;

/**
 * author: code.babe
 * date: 2016-08-27 11:07
 */
public class Regular {


    /**
     * construct method, inject by set method
     * @param injectName
     * @return
     */
    public static String regularInjectName(String injectName) {
        if (!StringUtils.isNotEmpty(injectName)) {
            return StringUtils.Param.EMPTY_STRING;
        }
        return "set" + standardizingName(injectName);
    }

    public static String standardizingName(String unstantard) {
        if (!StringUtils.isNotEmpty(unstantard)) {
            return StringUtils.Param.EMPTY_STRING;
        }
        StringBuilder sb = new StringBuilder();
        char firstCharacter = unstantard.charAt(0);
        firstCharacter = firstCharacter < 'a' ? (char) (firstCharacter + 32) : (char) (firstCharacter - 32);
        sb.append(firstCharacter).append(unstantard.substring(1));
        return sb.toString();
    }

}
