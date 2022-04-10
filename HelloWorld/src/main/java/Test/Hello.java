package Test;

/**
 * Date:     2019/1/10 17:49
 */


public class Hello {
    public int i;

    class hh {
        int j;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "i=" + i +
                '}';
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        hh hh = hello.new hh();
//        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat secondFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar calendar = Calendar.getInstance();
//
//        Date date = calendar.getTime();
//        Date date1 = new Date();
//        Timestamp timestamp = new Timestamp(date1.getTime());
//        System.out.println("Date："+date);
//        System.out.println("Date1:"+date1);
//        System.out.println("CurrentTime :"+ System.currentTimeMillis());
//        System.out.println("TimeStamp："+timestamp.getTime());
//        String date2 = dayFormat.format(timestamp.getTime());
//        System.out.println("Date2 to String:"+date2);
//        try {
//            Date date3 = secondFormat.parse(date2);
//            System.out.println("Date3:"+date3);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        //Java 基本类型的包装类的大部分都实现了常量池技术，
        // 即Byte,Short,Integer,Long,Character,Boolean；这5种包装类默认创建了数值[-128，127]的相应类型的缓存数据，
        // 但是超出此范围仍然会去创建新的对象。
//        Integer i1 = 33;
//        Integer i2 = 33;
//        System.out.println(i1 == i2);// 输出true
//        Integer i11 = 333;
//        Integer i22 = 333;
//        System.out.println(i11 == i22);// 输出false
//        Double i3 = 1.2;
//        Double i4 = 1.2;
//        System.out.println(i3 == i4);// 输出false
//        String l = Integer.toHexString(157).toUpperCase() + "-" + Long.toHexString(System.currentTimeMillis())
//        .toUpperCase();
//
//        System.out.println(l);
//        l = l.split("-")[0];
//        try {
//            TimeUnit.SECONDS.sleep(2);//秒
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String shopId =String.valueOf(Integer.parseInt(l,16));
//        System.out.println(shopId);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.subList(3,4));

//        Map<String ,Integer> map = new HashMap<>();
//        map.put("1",1);
//        map.put("2",2);
//        map.put("3",3);
//        map.put("4",4);
//        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
//            System.out.println( stringIntegerEntry.getKey());
//            System.out.println(stringIntegerEntry.getValue());
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            list.add(i);
//        }
//        List<Integer> l = new ArrayList<>(list);
//        for (Integer integer : l) {
//            System.out.println(integer);
//        }

        //long转yyyyMMdd
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//        dateFormat.setLenient(false);
//        long time = 1571121272752L;
//        Date date = new Date(time);
//        System.out.println(dateFormat.format(date));
//        System.out.println(Integer.parseInt(dateFormat.format(date)));

        //test 找到链表中的某一值
//        List<User> list = new ArrayList<>();
//        User user = new User(1,1,"a");
//        User user2 = new User(2,2,"b");
//
//        list.add(user);
//        list.add(user2);
//        User user1 = list.stream().filter(b->2==b.getId() &&1==b.getAge()).findAny().orElse(null);
//        if(user1 == null){
//            System.out.println("user1 is null");
//        }else{
//            System.out.println("user1:"+user1.toString());
//        }
        //去掉字符串中的特殊符号
//        String str = "hehe \" \'nihao \n \" >  <!";
//        System.out.println(str);
//        String s = str.trim().replace("\r", "").replace("\n", "").
//                replace("\"", "").replace("\'", "").replace(">","").replace("<","");
//        System.out.println(s);
//        System.out.println("".length());

        //base64
//        String callback64
//        ="aHR0cHM6Ly9iYW5nLWludGVnLjU4LmNvbS9wYy8jL21haW4vYnRva2VuPThlNzVkYjBiMTRkNTQzMWQ5ZjI3MGViZmRiZjc0ODVkJmJpekxpbmVJZD0xJm5vX2J0b2tlbj0x";
//        String url = new String(Base64.getUrlDecoder().decode(callback64), StandardCharsets.UTF_8);
//        System.out.println(url);
//        String key = "lc";
//        if (url == null || StringUtils.isBlank(key)) {
//            return ;
//        }
//        key = key.trim();
//        Matcher matcher = Pattern.compile("[/|\\&]" + key + "=\\w*").matcher(url);
//        if (!matcher.find()) {
//            return ;
//        }
//        String value = matcher.group().split("=")[1].trim();
//        if (value.isEmpty()) {
//            return ;
//        }
//        System.out.println(value);
        //去掉字符串重特殊符号
//        String regEx = "[\n\r`~!@#$%^&*()+=|{}':;',\\[\\]
//        .<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？\"]";
////
////        //可以在中括号内加上任何想要替换的字符，实际上是一个正则表达式
////        String empty = "";
////        String aa = "年四点、\r \n .sda十大\'d\" \r&^*&%$$&* \'sad\" dasd> <";
////        Pattern p = Pattern.compile(regEx);
////
////        Matcher m = p.matcher(aa);//这里把想要替换的字符串传进来
////
////        String newString = m.replaceAll(empty).trim();
////        System.out.println(newString);
        //112优信客服
//        String list =
//                        "67145344418583,67138103224086,67145554092823,67145521648407,67137940977687,67146142666263," +
//                        "67145615206679,66034797179920,67100037868310,67100072223511,67099927248662,67100036855319," +
//                        "67099889629207,67099941823767,67100040167191,67100839153175,67100978728983,67100898031894," +
//                        "67100779469335,67100953063190,67100815442454,66630548672533,67100922357015,67100875312151," +
//                        "65950762819852,65200079601928,65199916163598,65200140676373,65200103950867,65199880355078," +
//                        "65199966916622,43579889931790,18346735178758,67145789797398,67146173560342,67145878295063," +
//                        "67145789138710,67145902721046,67145953392918,67146172192535,67146048744726,67145983654935," +
//                        "38684065269008,67114805324823,67114634204951,67114448549398,67144630725143,67144850631446," +
//                        "67144559978007,67144633124886,67144615651863,67144584530454,67140983186711,65211605555981," +
//                        "67144911670551,67100830870807,67100135091478,67100981697558,67100084091414,67100543890710," +
//                        "67100082157846,67100543181591,67102199800599,67102001464855,67102021809942,67101979502359," +
//                        "67102009213462,67107839963414,67115978315799,67102264271127,67102131223063,67102240652822," +
//                        "67107122337559,67107305313559,67121659773463,67107123958806,67107684702999,67107117292311," +
//                        "67120485885719,67121530576918,67121630584855,67121592265238,67121513024791,67121500930071," +
//                        "67121676059671,67121727521302,67121499473942,67099866337814,67099846930455,67099829721110," +
//                        "67099862936342,67100109240854,67099866194711,67099870838294,67099825532951,67099996174871," +
//                        "67099896970262,67123574165014,67115960271894,67123738271255,67123691463446,67123657125399," +
//                        "67116044785687,67138989706775,67123651882263,67123600971286,67099849269526,67099793185814," +
//                        "67099985307415,67100134981911,67100000605719,67099896707095";
        String list =
                "67209227329559,67148007258903,67147006282263,67146917045783,67146853957143,67146791584535," +
                        "67146772686358,67146410770711,67146173560342,67146172192535,67146142666263,67146048744726," +
                        "67145983654935,67145953392918,67145902721046,67145878295063,67145789797398,67145789138710," +
                        "67145615206679,67145554092823,67145521648407,67145344418583,67138989706775,67138103224086," +
                        "67137940977687,67123738271255,67123691463446,67123657125399,67123651882263,67123600971286," +
                        "67123574165014,67121727521302,67121676059671,67121659773463,67121592265238,67121530576918," +
                        "67121513024791,67121500930071,67121499473942,67120485885719,67116044785687,67115978315799," +
                        "67115960271894,67114805324823,67114634204951,67114448549398,67107839963414,67107684702999," +
                        "67107305313559,67107123958806,67107122337559,67107117292311,67102264271127,67102240652822," +
                        "67102210001175,67102199800599,67102131223063,67102023165975,67102021809942,67102009213462," +
                        "67102001464855,67100981697558,67100978728983,67100953063190,67100922357015,67100898031894," +
                        "67100875312151,67100839153175,67100830870807,67100815442454,67100800208918,67100787150359," +
                        "67100779469335,67100674818583,67100632793623,67100629620246,67100618339863,67100543181591," +
                        "67100453935895,67100109240854,67100082157846,67100072223511,67100037868310,67099996174871," +
                        "67099985307415,67099941823767,67099896970262,67099870838294,67099866337814,67099866194711," +
                        "67099862936342,67099849269526,67099846930455,67099829721110,67099825532951,67099793185814," +
                        "66630548672533,66630111302933,66568160748037,66568102001684,66568076938762,66568043044112," +
                        "66567985267720,66567945117203,66542895007759,66539032129799,66527829509649,66527819468556," +
                        "66527771062287,66527681298693,66527317206031,66099075144714,66034797179920,65951653257226," +
                        "65951634414096,65951633513997,65951632439311,65951627758347,65203264163093,65199987141126," +
                        "65199966916622,65199915454730,65199866910228,63869944739093,55649711635471,39757352348944," +
                        "39426043641879,38684065269008,18346735178758,13596826520839,10723466731783";
        int i = 0;
        for (String uid : list.split(",")) {
            System.out.println(uid);
            i++;
        }
        System.out.println(i);


//        List<Object> list =  new ArrayList<>();
//        list.add(2);
//        list.add(11.2);
//        list.add(0.1);
//        Object obj = 0;
//        for (Object o : list) {
//
//            System.out.println();
//        }

    }

}