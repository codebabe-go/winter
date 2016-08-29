package codebabe.library.winter.utils;

import codebabe.library.winter.factory.ClzStreamLoader;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * author: code.babe
 * date: 2016-08-26 16:49
 */
public class ClassUtils {

    // match protocol
    public static final String PROTOCOL = "file";

    private ClassUtils() {}

    /**
     * @param completedName erased suffix ".class"
     * @return
     * @throws ClassNotFoundException
     */
    public static Class loadClassByName(String completedName) throws ClassNotFoundException {
        return Thread.currentThread().getContextClassLoader().loadClass(completedName);
    }

    /**
     *
     * @param packageName
     * @return
     */
    public static URL getURLByPkgName(String packageName) {
        String path = packageName.replaceAll("\\.", "/");
        return Thread.currentThread().getContextClassLoader().getResource(path);
    }

    public static Set<Class> loadClassByAnnotationType(Set<File> clzFiles, String pkgName, Class annotation) throws ClassNotFoundException {
        Set<Class> classes = loadClassesFromFile(clzFiles, pkgName);
        Set<Class> retBeans = new HashSet<Class>();
        for (Class clz : classes) {
            Annotation bean = clz.getAnnotation(annotation);
            if (null != bean) {
                retBeans.add(clz);
            }
        }
        return retBeans;
    }

    public static Set<Class> loadClassByAnnotationByFiled(Set<File> clzFiles, String pkgName, Class annotation) throws ClassNotFoundException {
        Set<Class> classes = loadClassesFromFile(clzFiles, pkgName);
        Set<Class> retBeans = new HashSet<Class>();
        for (Class clz : classes) {
            // get all(private, protected, public) fields
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                if (null != field) {
                    try {
                        Annotation bean = field.getAnnotation(annotation);
                        // this class contains this annotation
                        if (null != bean) {
                            retBeans.add(clz);
                            // break current loop of fields
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return retBeans;
    }

    /**
     * transforms from file to type class
     *
     * @param clzFiles file which contains class(not type class, just a file)
     * @return
     */
    private static Set<Class> loadClassesFromFile(Set<File> clzFiles, String pkgName) throws ClassNotFoundException {
        Set<Class> clzss = new HashSet<Class>();
        for (File item : clzFiles) {
            String path = item.getAbsolutePath();
            String temp = PathUtils.subPath(path, pkgName.replaceAll("\\.", "/"));
            String completedName = temp.substring(0, temp.length() - ClzStreamLoader.Param.CLZ_SUFFIX.length()).replaceAll("/", "\\.");
            Class clz = ClassUtils.loadClassByName(completedName);
            clzss.add(clz);
        }
        return clzss;
    }

}
