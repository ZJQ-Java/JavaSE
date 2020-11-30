package IO;

import java.io.*;

/**
 * Date:     2019/2/19 14:43
 */
public class ReadFile {
    public ReadFile() {
    }

    /**
     * 读取某个文件夹下的所有文件
     */
    public static boolean readFile(String filepath) throws FileNotFoundException, IOException {
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("absolutepath=" + readfile.getAbsolutePath());
//                        readFileStream(readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());

                    } else if (readfile.isDirectory()) {
                        readFile(filepath + "\\" + filelist[i]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }
//    public static void readFileStream(String pathname) {
//        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
//        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
//        //不关闭文件会导致资源的泄露，读写文件都同理
//        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
//        try (
//                FileReader reader = new FileReader(pathname);
////             InputStreamReader reader = new InputStreamReader (new FileInputStream(pathname),"gbk");
//
//             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
//        ) {
//            String line;
//            //网友推荐更加简洁的写法
//            while ((line = br.readLine()) != null) {
//                // 一次读入一行数据
//                System.out.println(line);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer buf = new StringBuffer();

        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                buf.append(tempString);
//                buf.append("\r\n");
                // 显示行号
//                System.out.println("line " + line + ": " + );
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) {
//        try {
//            readFile("D:/videos");
//            // deletefile("D:/file");
//        } catch (FileNotFoundException ex) {
//        } catch (IOException ex) {
//        }
//        System.out.println("ok");
//        String s = readFileByLines("C:\\Users\\zhangjinqiu03\\Desktop\\新建文本文档.txt");
//        String[] split = s.split(",");
//        for (String s1 : split) {
//            System.out.println(s1);
//        }
//        Set<String> collect = Arrays.stream(split).map(o -> o.replaceAll(" ", "")).collect(Collectors.toSet());
//        System.out.println(collect);
    }

}