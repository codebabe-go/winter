package codebabe.library.winter;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by LL on 16/8/29.
 */
public class Class1Mocked extends TestCase {

    private String name;



//    @BeforeClass
    {
        name = "lanlv";
    }

    @Test
    public void testHello() {
        Assert.assertTrue(name.equals("lanlv"));
    }

    public String hello(String name) {
        System.out.println(name);
        return name;
    }
//    @Test

//    @Test
//    public void show(){
//        System.out.println("Class1Mocked.show()");
//    }


}

