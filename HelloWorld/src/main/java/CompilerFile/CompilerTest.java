package CompilerFile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * Date:     2019/1/10 16:46
 */
public class CompilerTest {
    public static void compilerFile(String input){
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        int result = javaCompiler.run(null,null,null,input);
        String strResult = result == 0 ?"编译成功" :"编译失败";
        System.out.println(strResult);
    }
    public  static void fun(String... str){
        for (String s : str) {
            System.out.println(s);
        }
    }
    public static void print() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("java -cp D:/IdeaProjects/test Test.Hello");
        InputStream inputStream =process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String result = "";
        while((result = bufferedReader.readLine()) != null){
            System.out.println(result);
        }
    }
    public static void main(String[] args) throws IOException {
        compilerFile("D:/IdeaProjects/test/Test.Hello.java");
        print();
        fun("1");
        fun("123","adsas");
        fun("z","j","q");
    }
}
