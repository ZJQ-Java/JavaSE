package serializeMethod;

import java.io.Serializable;

/**
 * Author:   zhangjinqiu03
 * Date:     2019/1/9 10:14
 */
public class Person implements Serializable{   //一定要实现一下Serializable
    private final long serialVersionUID = 1;
    private int id;
    private transient String name;   //序列化的时候保证不被序列化
    private int age;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Person(int id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }
}
