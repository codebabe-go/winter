package codebabe.library.winter.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.apache.log4j.Logger;

/**
 * author: code.babe
 * date: 2016-08-30 13:02
 */
public class GsonUtil {

    private static final Logger logger = Logger.getLogger(GsonUtil.class);

    private static Gson gson = null;

    private static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd H:mm:ss";

    static {
        gson = new GsonBuilder().setDateFormat(yyyy_MM_dd_HH_mm_ss).create();
    }

    public static String toJSON(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJSOM(String json, Class<T> classOfT) {
        try {
            return gson.fromJson(json, classOfT);
        } catch (JsonSyntaxException e)  {
            logger.error(String.format("format to class error, json = %s, type = %s", json, classOfT.getTypeName()));
        }
        return null;
    }

}
