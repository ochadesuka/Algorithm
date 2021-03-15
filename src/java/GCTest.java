import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class GCTest {
    private static Object r1 = new Object();
    private static Object r2 = new Object();
    public static void main(String[] args) {
            new Thread(() -> {
                synchronized (r1) {
                    System.out.println(Thread.currentThread() + " r1");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " wait r2");
                    synchronized (r2) {
                        System.out.println(Thread.currentThread() + " r2");
                    }
                }
            }, "线程1").start();

        new Thread(() -> {
            synchronized (r2) {
                System.out.println(Thread.currentThread() + " r2");
                try {
                    Thread.sleep(1000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " wait r1");
                synchronized (r1) {
                    System.out.println(Thread.currentThread() + " r1");
                }
            }
        }, "线程2").start();

    }
}
