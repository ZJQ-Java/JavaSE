package Recursion;

public class Sum100 {
    public static int evenSum(int n) {
        int sum = 0;
        if (n == -1) {
            return sum;
        } else {
            if (n % 2 == 0) {
                return sum = n + evenSum(n - 1);
            } else {
                return evenSum(n - 1);
            }
        }

    }

    /**
     * 计算1-100以内的和
     * n为要计算的数值(100)
     * sum为总和
     */
    public static int totalSum(int n) {
        int sum = 0;
        if (n == -1) {
            return sum;
        } else {
            return sum = +n + totalSum(n - 1);
        }
    }

    public static int fac(int num) {
        if (num == 1) {
            return 1;
        }
        return num * fac(num - 1);
    }

    public static void print(int n) {
        if (n > 9) {
            print(n / 10);
        }
        System.out.print(n % 10);
    }

    public static void main(String[] args) {
        //计算1-100以内偶数的和
        System.out.println(totalSum(10));
        print(12345);
        //计算1-100以内的和
//        System.out.println(evenSum(100));
    }
}
