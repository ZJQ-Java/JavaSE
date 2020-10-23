package serializeMethod;

import java.io.*;
import java.time.Period;

/**
 * Author:   zhangjinqiu03
 * Date:     2019/1/9 10:08
 */
public class PersonTest {
    public static void serializeMethod(String destPath) throws IOException {
        Person person =new Person(1,"zjq",22);
        //建立联系
        File file = new File(destPath);
        //选择流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        // 操作
        objectOutputStream.writeObject(person);
        //关闭流
        objectOutputStream.close();
    }
    public static void readObject(String srcPath) throws IOException, ClassNotFoundException {
        //建立联系
        File file = new File(srcPath);
        //选择流
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        //操作
        Object object = objectInputStream.readObject();
        if(object instanceof Person){
            Person person =(Person) object;
            System.out.println(person);
        }
        objectInputStream.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeMethod("D:/fileTest/serialize.txt");
        readObject("D:/fileTest/serialize.txt");
    }
}
