package test.library.winter.main.model;

/**
 * author: code.babe
 * date: 2016-08-28 23:32
 */
public class Man {

    public Man() {}

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void introduceMyself() {
        System.out.println(String.format("Hello, my name is %s, I'm %d years old", this.name, this.age));
    }
}
