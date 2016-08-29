package codebabe.library.winter.env;

/**
 * author: code.babe
 * date: 2016-08-29 09:44
 */
public interface EnvironmentSwitch {

    <T> void init(T... params) throws ClassNotFoundException;

}
