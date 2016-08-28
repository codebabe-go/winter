package codebabe.library.winter.factory;

import codebabe.library.winter.anno.Bean;
import codebabe.library.winter.utils.ClassUtils;
import codebabe.library.winter.utils.FileUtils;
import codebabe.library.winter.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * author: code.babe
 * date: 2016-08-26 10:04
 * static util, provide bean factory
 */
public class ClzStreamLoader {

    /**
     * class public parameters
     */
    public interface Param {
        String CLZ_SUFFIX = ".class";
    }

    private ClzStreamLoader() {
    }

    /**
     * generate bean factory which class contains annotation: @Bean
     *
     * @return
     * @throws ClassNotFoundException
     */
    @Deprecated
    public static final Set<Class> getAllBean() throws ClassNotFoundException, IOException {
        return getAllBean(ClzStreamLoader.class);
    }

    public static final Set<Class> getAllBean(Class envClz) throws ClassNotFoundException, IOException {
        return null == envClz ? Collections.EMPTY_SET : getAllBean(envClz.getClass().getPackage().getName());
    }

    public static final Set<Class> getAllBean(String pkgName) throws ClassNotFoundException, IOException {
        Set<Class> retBeans = new HashSet<Class>();
        if (StringUtils.isNotEmpty(pkgName)) {
            String pkgTmpPath = pkgName.replaceAll("\\.", "/");
            // get completed path(append prefix "file")
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(pkgTmpPath);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                if (ClassUtils.PROTOCOL.equals(url.getProtocol())) {
                    String path = url.getPath();
                    Set<File> clzFiles = FileUtils.listAllFiles(path);
                    retBeans = ClassUtils.loadClassByAnnotationType(clzFiles, pkgName, Bean.class);
                }
            }
        }
        return retBeans;
    }

}
