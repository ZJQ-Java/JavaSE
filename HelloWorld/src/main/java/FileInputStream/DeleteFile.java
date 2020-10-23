package FileInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Date:     2019/2/19 14:50
 */
public class DeleteFile {
    /**
     * 删除某个文件夹下的所有文件夹和文件
     */
    public static boolean deletefile(String delpath) throws FileNotFoundException, IOException {
        try {
            File file = new File(delpath);
            if (!file.isDirectory()) {
                    System.out.println("1");
                    file.delete();
            } else if (file.isDirectory()) {
                    System.out.println("2");
                    String[] filelist = file.list();
                    for (int i = 0; i < filelist.length; i++) {
                            File delfile = new File(delpath + "\\" + filelist[i]);
                            if (!delfile.isDirectory()) {
                                    System.out.println("path=" + delfile.getPath());
                                    System.out.println("absolutepath="
                                                    + delfile.getAbsolutePath());
                                    System.out.println("name=" + delfile.getName());
                                    delfile.delete();
                                    System.out.println("删除文件成功");
                            } else if (delfile.isDirectory()) {
                                    deletefile(delpath + "\\" + filelist[i]);
                            }
                    }
//                            file.delete();

            }

        } catch (FileNotFoundException e) {
                System.out.println("deletefile()   Exception:" + e.getMessage());
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            deletefile("D:/videos");
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        System.out.println("ok");
    }

}
