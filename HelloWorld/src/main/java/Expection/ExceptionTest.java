package Expection;

/**
 * Author:   zhangjinqiu03
 * Date:     2019/1/9 10:39
 */
public class ExceptionTest {
    public static void arithmetic(int molecule, int denominatior) {  //算数异常
        if (denominatior != 0) {
            System.out.println(molecule / denominatior);
        }

    }

    public static void arrayMethed(String[] arr) {  //数组异常

        if (arr.length > 100) {
            System.out.println(arr[100]);
        }
    }

    public static void nullPointMethod(String str) {
        if (str != null && !"".equals(str))
            System.out.println(str.trim());
    }

    public static void main(String[] args) {
//        arithmetic(110,0);
//        arrayMethed(new String[] {"1","22","334"});
//        nullPointMethod(null);
        byte b = 0x1;
        System.out.println(b);
        byte b1 = 0x2;
        System.out.println(b1);

        byte b2 = 0x3;
        System.out.println(b2);

        System.out.println("b+b1=" + (b + b1));

    }
}
