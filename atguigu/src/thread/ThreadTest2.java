package thread;

/**
 * 练习：创建两个分线程，让其中一个线程输出1-100之间的偶数，另一
 * 个线程输出1-100之间的奇数。
 */

public class ThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread thread1 = new Thread(t1, "thread 1");
        Thread thread2 = new Thread(t2, "thread 2");
        thread1.start();
        thread2.start();
        for (int i = 100; i < 200 ; i ++) {
            if (i == 120) {
                thread1.join();
            }
            if (i == 150) {
                Thread.currentThread().sleep(2000);
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }


}


class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}