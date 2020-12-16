package Date;

import java.util.Date;

/**
 * Date:     2019/1/21 14:41
 */
public class DateTest {
    public void method(){
        long starttime = System.currentTimeMillis();
        int j = 1;
        for(int i =0;i<100;i++){
            j++;
        }
        System.out.println("cost time:"+(System.currentTimeMillis()-starttime));
    }
    public static void main(String[] args) {
        //使用无参的Date的方法创建Date对象
//        Date date = new Date();
//        System.out.println("无参的："+date);
//        //使用有参数的Date创建一个对象
//        Date date1 =  new Date(System.currentTimeMillis()+1100);
//        System.out.println("有参数的："+date1);
        Date date = new Date();
        date.setTime(1607483029000L);
        System.out.println(date.toLocaleString());
        //Thu Jan 01 08:00:00 CST 1970
//        System.out.println(new Date(0));
//        Date date2 = new Date(3600*1000);
//        System.out.println(date2);
//        System.out.println(date2.toString());
//        //获得从1970年到现在的毫秒数
//        long gettime = date.getTime();
//        System.out.println(gettime);
//
//        Date date3 = new Date(gettime);
//        System.out.println("date3:"+date3);
//        date2.setTime(gettime);
//        System.out.println("use getTime:"+date2);
//        //将时间戳变成Date
//        String strDate = "1549866619506";
//        long lt = new Long(strDate);
//        Date date4 = new Date(lt);
//        System.out.println(date4);

    }
}
