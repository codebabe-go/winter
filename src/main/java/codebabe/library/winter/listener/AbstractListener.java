package codebabe.library.winter.listener;

import codebabe.library.winter.listener.event.ListenEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: code.babe
 * date: 2016-08-25 20:58
 */
public abstract class AbstractListener implements BeanListener {

    public AbstractListener() {}

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    public void listening(final ListenEvent event) {
        // new a thread to run this asyn
        EXECUTOR_SERVICE.execute(new Runnable() {
            public void run() {
                try {
                    doEvent(event);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public abstract <T>void doEvent(ListenEvent event) throws ClassNotFoundException;
}
