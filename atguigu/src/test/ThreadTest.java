package test;

public class ThreadTest {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
        System.out.println("test");
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}


