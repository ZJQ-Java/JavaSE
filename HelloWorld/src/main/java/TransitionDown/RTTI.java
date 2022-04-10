package TransitionDown;

class Useful {
    public void f() {
        System.out.println("base:f()");
    }

    public void g() {
        System.out.println("base:g()");

    }
}

//向下转型
class MoreUseful extends Useful {
    @Override
    public void f() {
        System.out.println("MoreUseful:f()");
    }

    @Override
    public void g() {
        System.out.println("MoreUseful:g()");

    }

    public void u() {
        System.out.println("MoreUseful:u()");
    }

    public void v() {
    }

    public void w() {
    }
}

public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();
        // Compile time: method not found in Useful:
        //- x[1].u();
        ((MoreUseful) x[1]).u(); // Downcast/RTTI
        ((MoreUseful) x[0]).u(); // Exception thrown
    }
}