package codebabe.library.winter.listener.event;

/**
 * author: code.babe
 * date: 2016-08-26 14:48
 */
public class InjectEvent extends ListenEvent {

    private InjectEvent() {
        super();
    }

    public InjectEvent(String packageName) {
        super(packageName);
    }
}