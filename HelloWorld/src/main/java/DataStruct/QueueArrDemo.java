package DataStruct;

public class QueueArrDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.showQueue();
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.pop());

        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.pop());

        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.pop());

//        arrayQueue.add(4);
//        System.out.println(arrayQueue.peek());
//        arrayQueue.showQueue();


    }
}

class ArrayQueue {
    int[] arr;
    int   front;  //front 始终指向头的前一个位置
    int   real;
    int   maxSize;

    public ArrayQueue(int size) {
        arr = new int[size];
        front = -1;
        real = -1;
        maxSize = size;
    }

    public boolean isEmpty() {
        return front == real;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

    public void add(int i) {
        if (arr == null) {
            throw new RuntimeException("队列未初始化");
        }

        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        real++;
        arr[real] = i;
    }

    public boolean isFull() {
        return real > maxSize - 1;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
