package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        CacheMap cacheMap = new CacheMap();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cacheMap.put(String.valueOf(temp), String.valueOf(temp));
            }, String.valueOf(i)).start();
        }

        for (int j = 0; j < 5; j++) {
            final int temp = j;
            new Thread(() -> {
                cacheMap.get(String.valueOf(temp));

            }, String.valueOf(j)).start();
        }
    }

}

class CacheMap {
    public volatile Map<String, String> map = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        try {
            lock.writeLock().lock();
            System.out.println("put key :" + key + " value：" + value);
            map.put(key, value);
            System.out.println("put key :" + key + " value：" + value + " success");
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String get(String key) {
        try {
            lock.readLock().lock();
            System.out.println("get key :" + key);
            String s = map.get(key);
            System.out.println("get key :" + key + " success");
            return s;
        } finally {
            lock.readLock().unlock();
        }

    }
}