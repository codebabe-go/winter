package test.library.winter;

import codebabe.library.winter.utils.StringUtils;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * author: code.babe
 * date: 2016-08-26 23:53
 */
public class StringUtilsTest extends TestCase {

    @Test
    public void testSub() {
        String str = "test.library.winter";
        String ret = StringUtils.subString(str, ".");
        System.out.println(ret);
        Assert.assertTrue(ret.equals("winter"));
    }

}
