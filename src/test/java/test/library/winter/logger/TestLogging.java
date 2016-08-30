package test.library.winter.logger;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * author: code.babe
 * date: 2016-08-30 12:26
 */
public class TestLogging {

    private static Logger logger = null;

    @BeforeClass
    public static void before() {
        logger = Logger.getLogger(TestLogging.class);
    }

    @Test
    public void testLogging() {
        logger.error("hello logging");
    }

}
