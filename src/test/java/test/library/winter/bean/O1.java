package test.library.winter.bean;

import codebabe.library.winter.anno.Bean;
import codebabe.library.winter.anno.Inject;

/**
 * author: code.babe
 * date: 2016-08-26 13:38
 */
@Bean
public class O1 {

    public O1() {}

    public O1(String name) {
        this.name = name;
    }

    private String name = "default";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * print name, test reflect
     */
    public void print() {
        System.out.println(this.name);
    }
}
