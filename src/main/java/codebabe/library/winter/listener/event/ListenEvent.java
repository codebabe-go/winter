package codebabe.library.winter.listener.event;

/**
 * author: code.babe
 * date: 2016-08-26 13:23
 *
 */
public class ListenEvent {

    public ListenEvent() {}

    public ListenEvent(String packageName) {
        this.packageName = packageName;
    }

    private String packageName;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
