package test.library.winter.main;

import org.junit.Assert;
import org.junit.Test;
import test.library.winter.main.model.CallBackMan;
import test.library.winter.main.model.Man;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: code.babe
 * date: 2016-08-28 23:29
 *
 * call the method of inject bean, which is not initialize, inject by reflecting
 */
public class TestMainFunction {

    private CallBackMan callBackMan;

    /**
     * only new instance and not inject
     */
    @Test
    public void testCase1() {
        // Man isn't initialized
        CallBackMan callBackMan = new CallBackMan();
        try {
            callBackMan.callback();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof NullPointerException);
        }
    }

    /**
     * new an instance and inject by reflect to setter
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void testCase2() throws InvocationTargetException, IllegalAccessException {
        CallBackMan callBackMan = new CallBackMan();
        // inject
        Class clz = callBackMan.getClass();
        boolean result = false;
        for (Method method : clz.getDeclaredMethods()) {
            // callback setter
            if (method.getName().startsWith("set")) {
                method.invoke(callBackMan, new Man("fangzhe", 22));
            }
        }
        Assert.assertTrue(callBackMan.callback());
    }

    @Test
    public void testCase3() throws InvocationTargetException, IllegalAccessException {
        Class clz = this.getClass();
        CallBackMan callBackMan = new CallBackMan();
        // inject into test case
        for (Method method : clz.getDeclaredMethods()) {
            if (method.getName().startsWith("set")) {
                method.invoke(this, callBackMan);
            }
        }
        Class manClz = callBackMan.getClass();
        for (Method method : manClz.getDeclaredMethods()) {
            // callback setter
            if (method.getName().startsWith("set")) {
                method.invoke(callBackMan, new Man("fangzhe", 22));
            }
        }
        Assert.assertTrue(callBackMan.callback());
    }






    public CallBackMan getCallBackMan() {
        return callBackMan;
    }
}
