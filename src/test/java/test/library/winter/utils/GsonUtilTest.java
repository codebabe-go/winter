package test.library.winter.utils;

import codebabe.library.winter.utils.GsonUtil;
import org.junit.Test;

import java.util.Date;

/**
 * author: code.babe
 * date: 2016-08-30 13:11
 */
public class GsonUtilTest {

    @Test
    public void test() {
        TestModel testModel = new TestModel(new Date(System.currentTimeMillis()), "test");
        System.out.println(GsonUtil.toJSON(testModel));
    }

    class TestModel {

        public TestModel(Date now, String name) {
            this.now = now;
            this.name = name;
        }

        private Date now;
        private String name;

        public Date getNow() {
            return now;
        }

        public void setNow(Date now) {
            this.now = now;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
