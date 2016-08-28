package test.library.winter.bean;

import codebabe.library.winter.anno.Bean;

/**
 * author: code.babe
 * date: 2016-08-26 13:39
 */
@Bean
public class O5 {

    public void print(O1 o1) {
        System.out.println(String.format("hello %s\n", o1.getName()));
    }

}
