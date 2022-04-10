package IO;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        /*OutputStream out = new FileOutputStream("./test.txt");
        String a = "123456789";
        byte[] buff = a.getBytes();
        FileInputStream inputStream = new FileInputStream("./test.txt");
        try {
            out.write(buff, 0, 3);
            out.flush();
            int len = 0;
//            for(int i=0;i<3;i++){
//                    System.out.println((char)inputStream.read());
//            }
            System.out.println((char)inputStream.read(buff));

//            out.write(buff, 0, 4);
//            for(int i=0;i<3;i++){
//                System.out.println((char)inputStream.read());
//            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\zhangjinqiu03\\Desktop\\新建文本文档.txt");
        int n;
        byte[] bytes = new byte[32];
        StringBuffer buffer = new StringBuffer();
        while ((n = fileInputStream.read(bytes)) != -1) {
            buffer.append((char) n);
        }
        fileInputStream.close();
//        System.out.println(buffer.toString());
        System.out.println(new String(bytes));
//        File file = new File("C:\\Users\\zhangjinqiu03\\Desktop\\copy.txt");
//        if (!file.exists()) {
//            if (file.createNewFile()) {
//                FileOutputStream fileOutputStream  = new FileOutputStream(file);
//                fileOutputStream.write(buffer.toString().getBytes(StandardCharsets.UTF_8));
//                fileOutputStream.flush();
//                fileOutputStream.close();
//
//            }
//        }

    }

    static void fun(File file, String i) {
        if (file == null || file.listFiles() == null || file.listFiles().length == 0) {
            return;
        }
        for (File listFile : file.listFiles()) {
            System.out.println(i + listFile);
            fun(listFile, i + " ");
        }
    }

}
