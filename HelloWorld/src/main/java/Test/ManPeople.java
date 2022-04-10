package Test;

public class ManPeople extends People {
    private String muscle;

    public ManPeople() {
    }

    public ManPeople(String mouse, String nose, String muscle) {
        super(mouse, nose);
        this.muscle = muscle;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    @Override
    public String toString() {
        return "ManPeople{" +
                "muscle='" + muscle + '\'' +
                '}';
    }

    public static void main(String[] args) {
        People p = new ManPeople();
    }
}
