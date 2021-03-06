package codebabe.library.winter.factory.impl;

import codebabe.library.winter.exception.DuplicateBeanNameException;
import codebabe.library.winter.factory.BeanFactory;
import codebabe.library.winter.factory.ClzStreamLoader;
import codebabe.library.winter.listener.BeanListener;
import codebabe.library.winter.listener.event.ListenEvent;
import codebabe.library.winter.listener.impl.InjectBeanListener;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * author: code.babe
 * date: 2016-08-25 20:49
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private AbstractBeanFactory() {}

    public <T> AbstractBeanFactory(ListenEvent event, T env) throws ClassNotFoundException {
        this.event = event;
        init(env);
    }

    private BeanListener beanListener;

    private ListenEvent event;

    private  <T>boolean init(T env) throws ClassNotFoundException {
        boolean ret = false;
        try {
            Set<Class> classes = new HashSet<Class>();
            if (env instanceof String) {
                classes = ClzStreamLoader.getAllBean((String) env);
            }

            if (env instanceof Class) {
                classes = ClzStreamLoader.getAllBean((Class) env);
            }

            storeBean(classes);
            ret = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // default listener
        beanListener = new InjectBeanListener(this);
        beanListener.listening(event);
        return ret;
    }


    /**
     * provide multi storage, just like ram and persist(redis or db)
     * the data to store is binary steam
     * @param classes
     */
    protected abstract void storeBean(Set<Class> classes) throws DuplicateBeanNameException, IllegalAccessException, InstantiationException;


}
