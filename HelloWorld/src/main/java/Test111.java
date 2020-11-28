import ReflectTest.User;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Array;
import java.util.*;

public class Test111 {
    private static int                        age;
    private static int                        tall;
    public         Map<Integer, List<String>> map = new HashMap<>();

    public static void fun() throws Exception {
        throw new Exception("dadsa");
    }

    public static void main(String[] args) throws Exception {
//        String split = "2.3.0.xlsx";
//        System.out.println(split.lastIndexOf("."));
//        System.out.println(split.indexOf("."));
//        String fileTyle = split.substring(split.lastIndexOf(".") + 1);
//        System.out.println(fileTyle);
//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        System.out.println(list);
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer next = iterator.next();
//            if(next==3){
//                iterator.remove();
//                continue;
//            }
//            System.out.println(next);
//        }
//        System.out.println(list);
//        for (Integer integer : list) {
//            if(integer == 3){
//                Test111.fun();
//            }
//            System.out.println(integer);
//        }
//        System.out.println("------------------");
//        Test111 t1 = new Test111();
//        t1.map.put(1, Arrays.asList("10", "11"));
//        t1.map.put(2, Arrays.asList("20", "22"));
//        t1.map.put(3, Arrays.asList("30", "33"));
//        t1.map.put(4, Arrays.asList("40", "44"));
//        t1.map.put(5, Arrays.asList("50", "55"));
//        t1.map.put(6, Arrays.asList("60", "66"));
//        t1.map.put(7, Arrays.asList("70", "77"));
//        Test111 t2 = new Test111();
//        t2.map.put(1, Arrays.asList("21", "51"));
//        t2.map.put(2, Arrays.asList("22", "52"));
//        t2.map.put(3, Arrays.asList("23", "53"));
//        t2.map.put(4, Arrays.asList("24", "54"));
//        t2.map.put(5, Arrays.asList("25", "55"));
//        t2.map.put(6, Arrays.asList("26", "56"));
//        t2.map.put(7, Arrays.asList("27", "57"));
//        List<String> strings = Arrays.asList("22");
//        List<Test111> list = new ArrayList<>();
//        list.add(t1);
//        list.add(t2);
//        boolean b = list.stream().anyMatch(o -> {
//            List<String> list1 = o.map.get(2);
//            return list1.stream().anyMatch(strings::contains);
//        });
//        System.out.println(b);

//        String str = "{\"eventId\":3001,\"msgNew\":{\"addRecentSender\":1,\"addRecentTo\":1,\"createTime\":1602484444535,\"idEncrypt\":0,\"msgId\":1315541225746526208,\"msgIndex\":4,\"msgInfo\":{\"applet\":\"58\",\"atAll\":0,\"atUsers\":[],\"atUsersEncrypte\":[],\"bg\":\"房产\",\"businessType\":\"二手房\",\"content\":\"{\\\"imExtra\\\":\\\"{\\\\\\\"msgCreatorIdentity\\\\\\\":1,\\\\\\\"isAIMsg\\\\\\\":true}\\\",\\\"msg\\\":\\\"您方便留下您的联系方式吗？我们会有专业的服务人员与您交流。\\\",\\\"type\\\":\\\"text\\\"}\",\"msgSource\":\"4\",\"msgType\":2,\"msgUuid\":\"\",\"options\":[{\"key\":\"unread_count_hide\",\"value\":\"1\"},{\"key\":\"groupinfo_version\",\"value\":\"0\"},{\"key\":\"groupmember_version\",\"value\":\"0\"},{\"key\":\"send_tips_ignore\",\"value\":\"1\"}],\"origin\":\"\",\"refer\":\"{\\\"invitation\\\":{\\\"id\\\":\\\"39545274529812\\\",\\\"cateid\\\":\\\"12\\\",\\\"role\\\":\\\"1\\\",\\\"refer_time\\\":1602483823857,\\\"title\\\":\\\"\\\",\\\"url\\\":\\\"\\\",\\\"rootcateid\\\":\\\"\\\",\\\"scene\\\":\\\"\\\",\\\"cityid\\\":\\\"\\\",\\\"cate_extra\\\":\\\"\\\",\\\"flow_source\\\":\\\"\\\"}}\",\"senderAppID\":\"10321\",\"senderDeviceId\":\"\",\"senderId\":\"819\",\"senderInfo\":\"{\\\"register\\\":0,\\\"avatar\\\":\\\"https://j1.58cdn.com.cn/git/ics-merchantEditionWap/img/v1/default_avatar@2x.png\\\",\\\"user_id\\\":\\\"819\\\",\\\"user_name\\\":\\\"testtesttest\\\",\\\"name_spell\\\":\\\"\\\",\\\"user_type\\\":\\\"9999\\\",\\\"user_source\\\":9999,\\\"gender\\\":0,\\\"user_version\\\":1579164193730}\",\"senderIp\":\"\",\"senderOpenId\":\"\",\"senderSource\":9999,\"showType\":\"text\",\"toAppID\":\"\",\"toDeviceId\":\"\",\"toId\":\"1201\",\"toInfo\":\"{\\\"register\\\":0,\\\"avatar\\\":\\\"\\\",\\\"user_id\\\":\\\"\\\",\\\"user_name\\\":\\\"\\\",\\\"name_spell\\\":\\\"\\\",\\\"user_type\\\":\\\"0\\\",\\\"user_source\\\":0,\\\"gender\\\":0,\\\"user_version\\\":0}\",\"toIp\":\"\",\"toOpenId\":\"\",\"toSource\":108},\"result\":1,\"senderShowedCount\":1,\"toShowedCount\":4,\"ttl\":15552000},\"sources\":[108,9999],\"traceId\":\"04e72c8a-d68d-4625-b1b6-bf11b72fd0b7\"}";
//        JSONObject json = JSONObject.parseObject(str);
////        System.out.println(json);
////        System.out.println(json.get("eventId"));
//        json.put("worker","1111@@108");
////        System.out.println(json);
////        System.out.println(json.toString());
////        System.out.println(json.toJSONString());
//        str = json.toJSONString();
//        byte[] bytes = str.getBytes();
//        System.out.println(new String(bytes));
//        int i = 0;
//        i = i|1<<3;
//        System.out.println(i);
//        if(i == 0b11111){
//            System.out.println(true);
//        }else{
//            System.out.println(0b11111);
//        }
        List<User> users = Arrays.asList(new User(1,1,"z"),new User(2,2,"g"));
        System.out.println(users);
        for (User user : users) {
            user.setAge(1);
        }
        System.out.println(users);

    }
}
