package ExtendTest;

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }

    protected void fun() {
        System.out.println("a");
    }
}

public class Chess extends BoardGame {


    Chess() {
        super(11);
        System.out.println("Chess constructor");
        fun();
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
