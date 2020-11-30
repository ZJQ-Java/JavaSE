package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Date:     2019/2/19 15:09
 */
public class WriteFile {
    public static void main( String[] args )
    {
        try{
            String data = "this is writeFile";

            File file =new File("D:/videos/WriteFile.txt");

            //if file doesnt exists, then create it
            if(!file.exists()){
                file.createNewFile();
            }

            //true = append file
//            FileWriter fileWritter = new FileWriter(file.getAbsoluteFile(),true);
//            fileWritter.write(data);
//            fileWritter.close();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();

            System.out.println("Done");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

