package test.library.winter;
import codebabe.library.winter.Class1Mocked;
import junit.framework.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * Created by LL on 16/8/29.
 */

public class MockTest {

    @Test
    public void testMockMethod(){
        Class1Mocked obj = mock(Class1Mocked.class);
        when(obj.hello("lanlv")).thenReturn("lll");
        Assert.assertTrue(obj.hello("lanlv").equals("lll"));
    }
}
