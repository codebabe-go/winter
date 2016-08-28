package codebabe.library.winter.factory;

import codebabe.library.winter.factory.impl.RAMBeanFactory;
import codebabe.library.winter.listener.event.InjectEvent;
import codebabe.library.winter.listener.event.ListenEvent;

/**
 * author: code.babe
 * date: 2016-08-25 21:28
 */
public class Factory {

    private static BeanFactory factory;

    private static final String PKG_NAME = Factory.class.getPackage().getName();

    private static Object lock = new Object();

    public static <T>BeanFactory createDefaultFactory(ListenEvent event, T env) {
        if (factory == null) {
            synchronized (lock) {
                factory = new RAMBeanFactory(event, env);
            }
        }
        return factory;
    }

    public static BeanFactory createDefaultFactory() {
        return createDefaultFactory(new InjectEvent(PKG_NAME), Factory.class);
    }

    public static BeanFactory createDefaultFactory(ListenEvent event) {
        return createDefaultFactory(event, Factory.class);
    }

    public static <T>BeanFactory createDefaultFactory(T env) {
        return createDefaultFactory(new InjectEvent(PKG_NAME), env);
    }

}
