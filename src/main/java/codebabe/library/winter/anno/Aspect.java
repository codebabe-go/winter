package codebabe.library.winter.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * author: code.babe
 * date: 2016-09-02 11:36
 * aop annotation, it need local_variable that is not used to accept this annotation
 * not set default value
 */
@Target(value = {ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * call this class
     * @return
     */
    Class call();

    String name();

}
