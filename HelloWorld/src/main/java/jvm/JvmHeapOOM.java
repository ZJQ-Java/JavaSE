package jvm;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JvmHeapOOM {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<byte[]>();

        new Thread(() -> {
            while (true) {
                System.out.println(new Date().toLocaleString() + Thread.currentThread() + "OOM");
                byte[] b = new byte[1024 * 1024];
                list.add(b);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 线程二
         new Thread(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                System.out.println(list.size());
                try {
                    byte[] bytes = new byte[1024*1024 /2];
                    list.add(bytes);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
