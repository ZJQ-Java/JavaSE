package Test;


public class NewHello {
    int i;

    public NewHello(int i) {
        this.i = i;
    }

    public NewHello() {
    }

    static public int testNullAble(int i, boolean flag) {
        if (flag) {
            return i;
        }
        return 0;
    }

    public static void main(String[] args) {
//        NewHello.testNullAble(2,);
        NewHello newHello = new NewHello(2);
        NewHello newHello1 = new NewHello(1);
//        System.out.println(newHello.getClass() == newHello1.getClass());
//        Class<NewHello> newHelloClass = NewHello.class;
        System.out.println(newHello.getClass().getResourceAsStream("/11.properties"));
//        int i;
//        byte[] bytes = new byte[1000];
//            try(InputStream resourceAsStream = newHello.getClass().getResourceAsStream("/11.properties")){
//            while( (i=resourceAsStream.read(bytes)) !=-1){
//                System.out.println(new String(bytes));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String s1 = newHello.getClass().getResource("").getPath();
        String s2 = newHello.getClass().getResource("/").getPath();
        String s3 = newHello.getClass().getResource("/11.properties").getPath();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
