package codebabe.library.winter.listener.impl;

import codebabe.library.winter.anno.Inject;
import codebabe.library.winter.factory.BeanFactory;
import codebabe.library.winter.listener.AbstractListener;
import codebabe.library.winter.listener.event.ListenEvent;
import codebabe.library.winter.utils.ClassUtils;
import codebabe.library.winter.utils.FileUtils;
import codebabe.library.winter.utils.Regular;
import codebabe.library.winter.utils.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Set;

/**
 * author: code.babe
 * date: 2016-08-25 20:58
 */
public class InjectBeanListener extends AbstractListener {

    private BeanFactory factory;

    public InjectBeanListener(BeanFactory factory) {
        this.factory = factory;
    }

    public InjectBeanListener() {
        super();
    }



    /**
     * scan all classes under package, and inject it to where calls this
     * @param event event.packageName
     */
    public void doEvent(ListenEvent event) throws ClassNotFoundException {
        String pkgName = event.getPackageName();
        URL url = ClassUtils.getURLByPkgName(pkgName);
        if (ClassUtils.PROTOCOL.equals(url.getProtocol())) {
            // path absolute path
            String path = url.getPath();
            Set<File> files = FileUtils.listAllFiles(path);
            // which use @inject annotation on filed
            Set<Class> beans = ClassUtils.loadClassByAnnotationByFiled(files, pkgName, Inject.class);
            for (Class bean : beans) {
                Field[] fields = bean.getDeclaredFields();
                // one class may contain more than one specific annotation
                for (Field field : fields) {
                    try {
                        Inject iBean = field.getAnnotation(Inject.class);

                        // inject
                        if (null != iBean) {
                            String beanName = iBean.name();
                            Object instanceBean = null;
                            if (StringUtils.isNotEmpty(beanName)) {
                                instanceBean = factory.getBean(beanName);
                            } else {
                                beanName = field.getName();
                                instanceBean = factory.getBean(beanName);
                            }
                            try {
                                inject(bean, instanceBean, event.getSrc(), beanName);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     *
     * @param clz inject bean into src
     * @param instanceBean
     * @param src
     * @param matchMethodName
     */
    private void inject(Class clz, Object instanceBean, Object src, String matchMethodName) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (Method method : clz.getDeclaredMethods()) {
            if (method.getName().equals(Regular.regularInjectName(matchMethodName))) {
//                Class[] types = method.getParameterTypes();
//                for (Class t : types) {
//                }
                method.invoke(src, instanceBean);
            }
        }
    }
}
