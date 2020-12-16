package CSV;

import ReflectTest.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CsvDemo {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        String[] titles = new String[]{"ID", "姓名"};
        String[] propertys = new String[]{"id", "name"};
        List<User> list = new ArrayList<User>();
        User user;
        user = new User();
        user.setId(1);
        user.setName("张三");
        list.add(user);
        user = new User();
        user.setId(2);
        user.setName("李四");
        list.add(user);
        exportCsv(titles, propertys, list);
    }

    /**
     * 导出生成csv格式的文件
     *
     * @param titles    csv格式头文
     * @param propertys 需要导出的数据实体的属性，注意与title一一对应
     * @param list      需要导出的对象集合
     * @return
     * @throws IOException              Created     2017年1月5日 上午10:51:44
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @author ccg
     */
    public static <T> String exportCsv(String[] titles, String[] propertys, List<T> list)
            throws IOException, IllegalArgumentException, IllegalAccessException {
        File file = new File("d:\\test.csv");
        //构建输出流，同时指定编码
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file), "gbk");

        //csv文件是逗号分隔，除第一个外，每次写入一个单元格数据后需要输入逗号
        for (String title : titles) {
            ow.write(title);
            ow.write(",");
        }
        //写完文件头后换行
        ow.write("\r\n");
        //写内容
        for (Object obj : list) {
            //利用反射获取所有字段
            Field[] fields = obj.getClass().getDeclaredFields();
            for (String property : propertys) {
                for (Field field : fields) {
                    //设置字段可见性
                    field.setAccessible(true);
                    if (property.equals(field.getName())) {
                        ow.write(field.get(obj).toString());
                        ow.write(",");
                    }
                }
            }
            //写完一行换行
            ow.write("\r\n");
        }
        ow.flush();
        ow.close();
        return "0";
    }

}
