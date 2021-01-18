package Stream;

import ReflectTest.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Student {

    /**
     * 学号
     */
    private long id;

    private String name;

    private int age;

    /**
     * 年级
     */
    private int grade;

    /**
     * 专业
     */
    private String major;

    /**
     * 学校
     */
    private String school;

    public Student(long id, String name, int age, int grade, String major, String school) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
    // 省略getter和setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}

public class TestStream extends User {
    public static List<Student> students = null;

    static {
        students = new ArrayList<Student>() {
            {
             /*   add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, null, 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));*/
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 25, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.print(n + " ");
            }
        }
    }

    public static void main(String[] args) {
//        boolean b = students.stream().anyMatch(student -> student.getAge() == 30);
//        System.out.println(b);
//        Map<Integer,String> map = students.stream().collect(Collectors.toMap(Student::getAge, Student::getName,(oldValue,newValue) -> newValue));
////        System.out.println(map);
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.println(entry);
//        }
//        WeekFields weekFields = WeekFields.ISO;
//        System.out.println(LocalDateTime.now().get(weekFields.weekOfWeekBasedYear()));
//        Optional<Student> optStu = students.stream().filter(student -> "信息安全".equals(student.getMajor())).findFirst();
//        System.out.println(optStu.get().toString());
//        List<String> names = Arrays.asList("shekhar", "rahul", "sameer");
//        for (String name : names) {
//            System.out.println(name);
//        }
//        Collections.sort(names, (first, second) -> first.length() - second.length());
//        for (String name : names) {
//            System.out.println(name);
//        }
//        Comparator<String> comparator = Comparator.comparingInt(String::length);
//        System.out.println(comparator.compare("123","1"));

//        User user = new User();
//        User user1 = null;
//
//        Optional<User> op1 = Optional.ofNullable(user1);
//        System.out.println(op1.isPresent());
//        System.out.println(op1.orElse(user));
//        System.out.println(op1.get());
//        List<String> collect = students.stream().map(Student::getMajor).filter(major -> !major.equals("信息安全")).distinct().collect(Collectors.toList());
//        for (String s : collect) {
//            System.out.println(s);
//        }
//        List<Integer> onlineSum = new ArrayList<>();
//        onlineSum.add(1);
//        onlineSum.add(2);
//        onlineSum.add(3);
//        onlineSum.add(4);
//        Integer sum = onlineSum.stream().reduce(Integer::sum).orElse(0);
//        System.out.println(sum);
//        TestStream testStream = new TestStream();
//        Optional<String> s = Optional.of("input");
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true

//        System.out.println("输出所有数据:");
//
//        // 传递参数 n
//        eval(list, n -> false);
//        Exception ee = new Exception();
//        for (Integer integer : list) {
//            if(integer.equals(3)){
//                try {
//                    ee.addSuppressed(new Exception("abc"));
//                    continue;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(integer);
//        }
//        if (ee.getSuppressed().length != 0) {
//            throw ee;
//        }
//        System.out.println("----------------");
//        String str = "2";
//        Optional<String> str1 = Optional.ofNullable(str);
//        System.out.println(str1);
//        ArrayList<String> objects = new ArrayList<>();
//        Optional.ofNullable(str).ifPresent(objects::add);
//        System.out.println(objects);

//        System.out.println(s2);
        List<Student> list = students;
        for (Student student : list) {
            System.out.println(student);
        }
        Function<Student, Integer> function = o -> o.getGrade() + 100;
        /*Map<String, Integer> collect = list.stream()
                .collect(Collectors.groupingBy(Student::getSchool, HashMap::new, Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Student::getGrade)), o -> o.map(function).orElse(null))));*/
        Map<String, List<Student>> collect = list.stream()
                .collect(Collectors.groupingBy(Student::getSchool, Collectors.toList()));
        System.out.println(collect);

        /*for (Map.Entry<String, List<Student>> stringListEntry : collect.entrySet()) {
            stringListEntry.getValue().sort((o1, o2) -> o2.getGrade() - o1.getGrade());
        }
        System.out.println(collect);*/

        /*Collections.sort(list, (o1, o2) -> o2.getAge()-o1.getAge());
        System.out.println(list);*/
        for (Map.Entry<String, List<Student>> entry : collect.entrySet()) {
            List<Student> value = entry.getValue();
            for (Student student : value) {
                student.setAge(0);
                student.setGrade(0);
                student.setId(0);
                student.setName("");
                student.setMajor("");
                student.setSchool("");

            }
        }
        System.out.println(collect);
    }
}
