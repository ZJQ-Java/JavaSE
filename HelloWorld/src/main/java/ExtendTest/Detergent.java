package ExtendTest;

public class Detergent extends Cleanser {
    // Change a method:
    @Override
    public void scrub() {
        append(" ExtendTest.Detergent.scrub()");
        super.scrub(); // Call base-class version
    }

    // Add methods to the interface:
    public void foam() {
        append(" foam()");
    }

    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}