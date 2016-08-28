package test.library.winter.main.model;

/**
 * author: code.babe
 * date: 2016-08-28 23:35
 */
public class CallBackMan {

    private Man man;

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public boolean callback() {
        man.introduceMyself();
        return true;
    }
}
