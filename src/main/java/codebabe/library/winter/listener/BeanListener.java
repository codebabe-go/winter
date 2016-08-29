package codebabe.library.winter.listener;

import codebabe.library.winter.listener.event.ListenEvent;

/**
 * author: code.babe
 * date: 2016-08-25 20:48
 */
public interface BeanListener {

    void listening(ListenEvent event) throws ClassNotFoundException;

    void doEvent(ListenEvent event) throws ClassNotFoundException;

}
