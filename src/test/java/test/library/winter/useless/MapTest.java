package test.library.winter.useless;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: code.babe
 * date: 2016-08-26 16:28
 */
public class MapTest extends TestCase {

    private Map<String, String> map = new ConcurrentHashMap<String, String>();

    @Test
    public void testPut() {
        map.put("fangzhe", "xixi");
        map.put("lanlv", "wuwu");
        Assert.assertTrue(map.size() != 0);
        String ret = map.put("fangzhe", "zeze");
        // return old value
        System.out.println(ret);
        Assert.assertNotNull(ret);
    }

}
