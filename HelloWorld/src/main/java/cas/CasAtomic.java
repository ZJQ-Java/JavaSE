package cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CasAtomic {
    static AtomicStampedReference<Integer> atomic = new AtomicStampedReference(1000, 2);

    public static void main(String[] args) {
        System.out.println(atomic.getStamp());
        System.out.println(atomic.getReference());
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    "a change result: " + atomic.compareAndSet(1000, 2, atomic.getStamp(), atomic.getStamp() + 1));
            System.out.println("a:" + atomic.getReference());

            System.out.println(
                    "a change result: " + atomic.compareAndSet(2, 66, atomic.getStamp(), atomic.getStamp() + 1));
            System.out.println("a:" + atomic.getReference());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b change result: " + atomic.compareAndSet(100, 2, 2, 3));


        }).start();
    }
}
