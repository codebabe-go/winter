package test.library.winter.utils;

import codebabe.library.winter.utils.Regular;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * author: code.babe
 * date: 2016-08-27 11:15
 */
public class RegularTest extends TestCase {

    @Test
    public void testStandardizingName() {
        Assert.assertTrue(Regular.standardizingName("helloWorld").equals("HelloWorld"));
        Assert.assertTrue(Regular.standardizingName("HelloWorld").equals("helloWorld"));
    }

    @Test
    public void testRegularInjectName() {
        Assert.assertTrue(Regular.regularInjectName("o5").equals("setO5"));
    }

}
