package codebabe.library.winter.factory.impl;

import codebabe.library.winter.anno.Bean;
import codebabe.library.winter.exception.DuplicateBeanNameException;
import codebabe.library.winter.exception.EnvironmentException;
import codebabe.library.winter.factory.BeanFactory;
import codebabe.library.winter.listener.event.ListenEvent;
import codebabe.library.winter.utils.Regular;
import codebabe.library.winter.utils.StringUtils;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: code.babe
 * date: 2016-08-26 16:19
 */
public class RAMBeanFactory extends AbstractBeanFactory {

    public <T> RAMBeanFactory(ListenEvent event, T env) throws ClassNotFoundException {
        super(event, env);
    }

    private static Map<String, Object> factory = new ConcurrentHashMap<String, Object>();

    public Object getBean(String name) {
        return factory.get(name);
    }

    public boolean isDestroyed() throws EnvironmentException {
        return factory == null || factory.size() == 0;
    }

    public void destroy() throws EnvironmentException {
        factory.clear();
    }

    protected void storeBean(Set<Class> classes) throws IllegalAccessException, InstantiationException {
        if (classes.size() > 0) {
            for (Class clz : classes) {
                Bean bean = (Bean) clz.getAnnotation(BeanFactory.ANNOTATION);
                String setName = bean.name();
                Object old = null;
                if (StringUtils.isNotEmpty(setName)) {
                    old =  factory.put(setName, clz.newInstance());
                } else {
                    String beanName = StringUtils.subString(clz.getName(), ".");
                    String putName = Regular.standardizingName(beanName);
                    old = factory.put(putName, clz.newInstance());
                }

                if (null != old) {
                    throw new DuplicateBeanNameException("define a same name with @Bean");
                }
            }
        }
    }

}
