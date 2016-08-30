package codebabe.library.winter;

import codebabe.library.winter.env.EnvironmentSwitch;
import codebabe.library.winter.factory.Factory;
import codebabe.library.winter.listener.event.InjectEvent;
import org.apache.log4j.Logger;

/**
 * author: code.babe
 * date: 2016-08-25 21:26
 *
 * default execution, u can also start(create) ur own switch
 */
public class DefaultEnvironmentSwitch implements EnvironmentSwitch {

    private static final Logger logger = Logger.getLogger(DefaultEnvironmentSwitch.class);

    private DefaultEnvironmentSwitch() {}

    public static <T> void start(T... eventParams) throws ClassNotFoundException {
        EnvironmentSwitch environmentSwitch = new DefaultEnvironmentSwitch();
        environmentSwitch.init(eventParams);
    }

    public <T> void init(T... params) throws ClassNotFoundException {
        if (params.length == 2) {
            if (params[0] instanceof String && params[1] instanceof Object) {
                Factory.createDefaultFactory(new InjectEvent((String) params[0], params[1]), "test.library.winter.bean");
                return;
            }
        }
        logger.error(String.format("params json = %s", params));
    }
}
