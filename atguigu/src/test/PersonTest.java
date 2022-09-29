package test;

public class PersonTest {
    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.eat();
//
//        Man m1 = new Man();
//        m1.eat();
//        m1.earnMoney();
//        m1.walk();
        // 多态性：父类的引用指向子类的对象
//        Person p2 = new Man();
//        p2.eat();

        Man m1 = new Man();
        PersonTest tes1 = new PersonTest();
//        tes1.func(m1);

        System.out.println("master");
        System.out.println("hot_fix");
    }

    public void func(Person p1) {
        p1.eat();
    }
}
