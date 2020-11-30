package Expection;

public class StackTrajectory {
    void f() {
        try {
            int i = 100 / 0;
        } catch (Exception e) {
//            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
//                System.out.println(stackTraceElement);
//            }
            //            e.printStackTrace();

            System.out.println("e:" + e + "    e.message:" + e.getMessage());
//            System.out.println(e.getMessage());
//            System.out.println(e.toString());

        }
    }

    void g() {
        f();
    }

    void k() {
        g();
    }

    public static void main(String[] args) {
        StackTrajectory stackTrajectory = new StackTrajectory();
        stackTrajectory.f();
        System.out.println("---------");
        stackTrajectory.g();
        System.out.println("---------");
        stackTrajectory.k();
        System.out.println("---------");
    }
}
