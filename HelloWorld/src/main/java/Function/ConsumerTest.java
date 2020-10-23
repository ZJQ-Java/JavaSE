package Function;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.function.Consumer;

public class ConsumerTest {
    public static class Item implements Comparable {
        private int index;
        private int value;

        public Item(int index, int value) {
            this.index = index;
            this.value = value;
//            System.out.println("constructor中初始数据为：" + toString());
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
            System.out.println("setValue(int):current value=" + value);
        }

        @Override
        public int compareTo(@NonNull Object o) {
            if (o instanceof Item) {
                Item item = (Item) o;
                return this.value - item.value;
            } else {
                System.err.println("wrong item obj");
            }
            return 1;
        }

        @Override
        public String toString() {
            return "Item:index=" + index + ".value=" + value;
        }
    }

    public static void main(String[] args) {
        /**
         * item.value=item.value*2
         */
        Consumer<Item> consumerDouble = item -> {
            if (item != null) {
                int value = item.getValue();
                item.setValue(value * 2);
            }
        };

        /**
         * item.value=1_000_000+item.value
         */
        Consumer<Item> consumerAddMilion = item -> {
            if (item != null) {
                int value = item.getValue();
                item.setValue(1_000_000 + value);
            }
        };

        /**
         * print item info
         */
        Consumer<Item> consumerPrint = item -> {
            String content = item == null ? "null" : item.toString();
            System.out.println("consumerPrint.print content=[" + content + "]");
        };

        //使用方法事例1
        Item item = new Item(1, 111);
        consumerDouble.andThen(consumerAddMilion)
                .andThen(consumerPrint);

//        //使用方法事例2
//        item = new Item(2, 222);
//        consumerDouble.andThen(consumerAddMilion)
//                .andThen(consumerPrint)
//                .accept(item);
//
//        //使用方法事例3.等价于使用方法事例1，显然事例1更加优雅
//        item = new Item(1, 111);
//        consumerDouble.accept(item);
//        consumerAddMilion.accept(item);
//        consumerPrint.accept(item);
    }

}
