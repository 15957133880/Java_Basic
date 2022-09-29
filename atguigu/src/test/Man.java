package test;

public class Man extends Person{
    //nothing
    //hot_fix

    boolean isSmoking;

    public void earnMoney() {
        System.out.println("man earn money");
    }

    @Override
    public void eat() {
        System.out.println("man eat");
    }

    @Override
    public void walk() {
        super.walk();
        System.out.println("man walk");
    }
}
