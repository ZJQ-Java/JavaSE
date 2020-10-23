package ThreadTest;

import java.util.concurrent.locks.StampedLock;

public class StampLockDemo {
    //StampedLock提供了乐观读锁，可取代ReadWriteLock以进一步提升并发性能；

    //StampedLock是不可重入锁。
    public final static StampedLock lock = new StampedLock();

    public int x;
    public int y;

    public void write(int x, int y) {
        long l = lock.writeLock();
        try {
            this.x = x;
            this.y = y;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite(l);
        }
    }

    public int read() {
        long l = lock.tryOptimisticRead(); //乐观锁版本号
        int x = this.x;
        int y = this.y;
        //如果版本号有变化
        if (!lock.validate(l)) {
            long l1 = lock.readLock(); // 获取悲观锁
            try {
                x = this.x;
                y = this.y;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(l1);
            }
        }
        return x + y;
    }
}
