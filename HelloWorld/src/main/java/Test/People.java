package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class People implements Comparable<People> {
    private String mouse;
    private String nose;
    private String name;
//    public Hello hello;
//
//    public Hello getHello() {
//        return hello;
//    }
//
//    public void setHello(Hello hello) {
//        this.hello = hello;
//    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public People(String mouse, String nose, int age) {
        this.mouse = mouse;
        this.nose = nose;
        this.age = age;
    }

    public People(String mouse, String nose) {
        this.mouse = mouse;
        this.nose = nose;
    }
    //


    public static List likeString(String likename) {
        List<People> list = new ArrayList<People>();
        list.add(new People("zjq", "k"));
        list.add(new People("zz", "m"));
        list.add(new People("qpd", "n"));
//        list.removeIf(l -> !l.getMouse().contains(likename) && !l.getNose().contains(likename));
//        list.forEach(System.out::println);
        System.out.println(list);
        for (People people : list) {
            if (people.getMouse().equals("zjq")) {
                people.setNose("zjqdmouse");
            }
        }
        System.out.println(list);
        return list;

    }

    public static void main(String[] args) {
//        likeString("");
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(1);
////        list.add(3);
////        list.add(4);
//        list.removeIf(o -> o.equals(1));
//        System.out.println(list.isEmpty());
//        System.out.println(list);
//        int i = 1;
//        do{
//            System.out.println(i++);
//        }while(i<3);
//        System.out.println();
//        People people = new People("z","jq");
//        people.setHello(new Hello());
//        people.getHello().i = 1;
//        System.out.println(people);
//        People people1 = people;
//        people1.getHello().i = 2;
//        System.out.println(people);
//        System.out.println(people1);
//        List<People> list = new ArrayList<>();
//        list.add(new People("zjq", "k", 1));
//        list.add(new People("zz", "m", 2));
//        list.add(new People("qpd", "n", 3));
//        List<People> k = new ArrayList<>();
//        k.add(new People("11", "2", 1));
//        for (People people : k) {
//            Optional<People> any = list.stream().filter(o -> o.getAge() == people.getAge()).findAny();
//        }

//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate.equals(LocalDate.now()));
//        Map<LocalDate,String> map= new HashMap<>();
//        map.put(LocalDate.now(),"1");
//        map.put(LocalDate.now().minusDays(1),"-1");
//        map.put(LocalDate.now().minusDays(2),"-2");
//        System.out.println(LocalDate.now().minusDays(-2));
        People[] peoples = new People[]{new People("1", "1", 1),
                new People("2", "3", 3),
                new People("1", "1", 4),
                new People("2", "3", 2)};
        Arrays.sort(peoples);
        for (int i = 0; i < peoples.length; i++) {
            System.out.println(peoples[i]);
        }
    }

    @Override
    public int compareTo(People o) {
        return this.age - o.getAge();
    }

    @Override
    public String toString() {
        return "People{" +
                "mouse='" + mouse + '\'' +
                ", nose='" + nose + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
