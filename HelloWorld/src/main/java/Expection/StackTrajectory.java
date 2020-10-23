package Expection;

public class StackTrajectory {
    void f(){
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.println(stackTraceElement);
            }
        }
    }
    void g(){
        f();
    }
    void k(){
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
