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

    public ListenEvent(String packageName, Object src) {
        this.packageName = packageName;
        this.src = src;
    }

    private String packageName;

    private Object src;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Object getSrc() {
        return src;
    }

    public void setSrc(Object src) {
        this.src = src;
    }
}
