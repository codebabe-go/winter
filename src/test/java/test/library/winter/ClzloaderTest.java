package test.library.winter;

import codebabe.library.winter.factory.ClzStreamLoader;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import test.library.winter.bean.BeanTest;
import test.library.winter.bean.O1;
import test.library.winter.main.model.CallBackMan;
import test.library.winter.main.model.Man;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: code.babe
 * date: 2016-08-26 12:20
 */
public class ClzloaderTest extends TestCase {

    @Test
    // Thread.currentThread().getContextClassLoader().loadClass()
    public void testLoader() throws ClassNotFoundException {
        // package name append(className)
        Class clz = Thread.currentThread().getContextClassLoader().loadClass(ClzStreamLoader.class.getPackage().getName() + ".ClzStreamLoader");
        Assert.assertNotNull(clz);
    }

    @Test
    public void testMainMethod() throws IOException, ClassNotFoundException {
        Assert.assertTrue(ClzStreamLoader.getAllBean("test.library.winter.bean").size() == 2);
    }

    @Test
    public void testFiled() {
        for (Field field : BeanTest.class.getDeclaredFields()) {
            System.out.println(field.getName());
        }
    }

    @Test
    public void testMethod() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        O1 o1 = new O1("test1");
        Class clz = o1.getClass();
        for (Method method : clz.getDeclaredMethods()) {
            if (method.getName().equals("print")) {
                method.invoke(clz.newInstance());
            }
        }
    }

    @Test
    public void testSetValueByMethod() throws InvocationTargetException, IllegalAccessException {
        O1 o1 = new O1();
        Class clz = o1.getClass();
        for (Method method : clz.getDeclaredMethods()) {
            if (method.getName().startsWith("set")) {
                method.invoke(o1, "hello reflect");
            }
        }
        Assert.assertTrue(o1.getName().equals("hello reflect"));
    }

    @Test
    public void testMethodParametersType() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        CallBackMan callBackMan = new CallBackMan();
        // inject
        Class clz = callBackMan.getClass();
        for (Method method : clz.getDeclaredMethods()) {
            // callback setter
            if (method.getName().startsWith("set")) {
                Class[] type = method.getParameterTypes();
                Assert.assertTrue(type.length == 1);
                for (Class t : type) {
                    System.out.println(t.getTypeName());
                    // package name append class name
//                    Assert.assertTrue(t.getTypeName().equals("man"));
                    Assert.assertTrue(t.newInstance() instanceof Man);
                }
            }
        }
    }
}
