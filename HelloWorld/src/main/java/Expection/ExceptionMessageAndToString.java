package Expection;

public class ExceptionMessageAndToString {
    public static void main(String[] args) {
        try {
            int i = 211 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e:" + e);
            System.out.println("e.toString:" + e.toString());
            System.out.println("e.getMessage :" + e.getMessage());

        }
    }
}
