package codebabe.library.winter.factory;

import codebabe.library.winter.anno.Bean;
import codebabe.library.winter.exception.EnvironmentException;

/**
 * author: code.babe
 * date: 2016-08-25 20:48
 */
public interface BeanFactory {

    Class ANNOTATION = Bean.class;

    /**
     * factory store object itself not its' class binary Stream
     * @param name
     * @return
     */
    Object getBean(String name);

    boolean isDestroyed() throws EnvironmentException;

    void destroy() throws EnvironmentException;

}
