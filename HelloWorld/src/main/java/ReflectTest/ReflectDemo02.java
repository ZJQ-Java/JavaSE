package ReflectTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        Class c1 = Class.forName("ReflectTest.ReflectAnnotation");
        TypeAnnotation annotation = (TypeAnnotation) c1.getAnnotation(TypeAnnotation.class);
        System.out.println(annotation.value());

        Field name = c1.getDeclaredField("name");
        System.out.println(name);
        FieldAnnotation fieldAnnotation = name.getAnnotation(FieldAnnotation.class);
        System.out.println(fieldAnnotation.columnsName());
        System.out.println(fieldAnnotation.length());
        System.out.println(fieldAnnotation.type());
    }
}

@TypeAnnotation("tb_ReflectAnnotation")
class ReflectAnnotation {
    @FieldAnnotation(columnsName = "id", length = 11, type = "int")
    private int    id;
    @FieldAnnotation(columnsName = "name", length = 10, type = "varchar")
    private String name;
    @FieldAnnotation(columnsName = "age", length = 11, type = "int")
    private int    age;

    public ReflectAnnotation() {

    }

    @Override
    public String toString() {
        return "ReflectAnnotation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public ReflectAnnotation(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}


@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeAnnotation {
    String value();
}

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldAnnotation {
    String columnsName();

    int length();

    String type();
}
