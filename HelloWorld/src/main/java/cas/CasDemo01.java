package cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo01 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        i.set(1);
        boolean b = i.compareAndSet(1, 20);
        System.out.println(i.get());
        boolean b1 = i.compareAndSet(1, 30);
        System.out.println(b1);
        System.out.println(i.compareAndSet(20,30));
        System.out.println("except: 30 " +i.get());
    }
}
