package test.library.winter;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * author: code.babe
 * date: 2016-08-26 10:03
 */
public class PathTest extends TestCase {

    @Test
    public void testAncestor() throws IOException {
        String packageName = "test.library.winter.bean".replaceAll("\\.", "/");
        System.out.println(packageName);
        Assert.assertTrue("test/library/winter/bean".equals(packageName));
        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageName);
        while (dirs.hasMoreElements()) {
            URL url = dirs.nextElement();
            Assert.assertTrue(url.getProtocol().equals("file"));
        }
    }

    @Test
    public void testCurrentPkgName() {
        Package pkgName = this.getClass().getPackage();
        System.out.println(String.format("package name = %s", pkgName));
        Assert.assertNotNull(pkgName);
    }

    public void test() {

    }

}
