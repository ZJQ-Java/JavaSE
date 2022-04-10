package IO;

import Expection.MyException;

import java.io.InputStream;
import java.io.*;

/**
 * Author:   zhangjinqiu03
 * Date:     2019/1/9 10:46
 */
public class BufferInputStreamTest {
    public static void method(String srcPath) throws MyException, IOException {

        java.io.InputStream inputStream = new BufferedInputStream(new FileInputStream(srcPath));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            String str = new String(bytes, 0, len);
            System.out.println(str);
        }
        throw new MyException("sdasdas");
        //  throw new MyException("小拳拳");
        //   inputStream.close();
    }

    public static void method1(String srcPath) {
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(srcPath));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read()) != -1) {
                String str = new String(bytes, 0, len);
                System.out.println(str);

            }
            //   return "success";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            System.out.println("FileNotFoundException");
//            System.out.println("getMessage:"+e.getMessage());
//            System.out.println("toString ： " +e.toString());
//            return "result:FileNotFoundException";
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
            //  return "result: IOException";

        } finally {
            try {
                System.out.println("finally");
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        try {
            method("D:/fileT/serialize.txt");
        } catch (IOException e) {
            e.printStackTrace();
            // System.out.println(e.getMessage());
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        method1("sss");
//        System.out.println(str);   //try catch finally 先try  如果抛异常 那么catch 然后 在return之前走finally 最后return
    }
}
