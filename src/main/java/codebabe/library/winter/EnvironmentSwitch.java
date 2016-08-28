package codebabe.library.winter;

import codebabe.library.winter.factory.BeanFactory;
import codebabe.library.winter.factory.Factory;
import codebabe.library.winter.listener.event.InjectEvent;

/**
 * author: code.babe
 * date: 2016-08-25 21:26
 */
public final class EnvironmentSwitch {

    private EnvironmentSwitch() {}

    public static void start(String packageName) {
        BeanFactory beanFactory = Factory.createDefaultFactory(new InjectEvent(packageName), packageName);
    }
}
