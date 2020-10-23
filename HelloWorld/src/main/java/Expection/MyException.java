package Expection;

/**
 * Author:   zhangjinqiu03
 * Date:     2019/1/9 11:15
 */
public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    @Override
    public String getMessage() {
        return "Override getMessage " + super.getMessage();
    }

    public static void main(String[] args) {
//        try {
//            f();
//        } catch (MyException e) {
//            e.printStackTrace(System.out);
//            System.out.println("------------");
//            e.printStackTrace();
//        }
//        try {
//            g();
//        } catch (MyException e) {
//            e.printStackTrace(System.out);
//            System.out.println("------------");
//            e.printStackTrace(System.err);
//        }
        try {
            throw new Exception("My Exception");
        } catch(Exception e) {
            System.out.println("Caught Exception");
            System.out.println(
                    "getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" +
                    e.getLocalizedMessage());
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}
