package Test;

/**
 * Date:     2019/3/4 15:16
 */
public class Variablelength {
    public static int  add(int a, int b) {
        return a+b;
    }

    public static double add(double a , double b){
        return a+b;

    }
    public static int add (int a ){
        return 1;
    }
    public static int add (int a, double b) {
        return 1;


    }
    public static int add (double a ,int b){
        return 1;
    }
    public static int add (int... a){                       //定义不定长参数方法
        int s= 0;
        for (int i=0; i<a.length; i++)
            //根据参数个数长度进行循环相加
            s+=a[i];
        return s;

    }
    public static void main(String args[]){
        System.out.println("调用add(int,int)方法中的："+ add(1,2));
        System.out.println("调用add(double, double)方法中的："+ add(1.0,2.999999));
        System.out.println("调用add(int)方法中的："+ add(1,2));
        //以下为调用不定长度的参数方法
        System.out.println("调用不定长度参数方法："+ add(1,2,3,4,5,6,10));
        System.out.println("调用不定长度参数方法："+ add(2));

    }
}
