package test.library.winter.bean;

import codebabe.library.winter.EnvironmentSwitch;
import codebabe.library.winter.anno.Inject;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * author: code.babe
 * date: 2016-08-26 21:12
 */
public class BeanTest extends TestCase {

    {
        EnvironmentSwitch.start("test.library.winter.bean");
    }

    @Inject
    public O5 o5;

    @Test
    public void test() {
        o5.print(new O1("BeanTest"));
    }

    public void setO5(O5 o5) {
        this.o5 = o5;
    }
}
