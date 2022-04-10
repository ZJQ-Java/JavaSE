/**
 * Date:     2019/3/4 11:07
 */
public class Generic<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Generic(T key) {
        this.key = key;
    }

    public static void showKeyValue1(Generic<?> obj) {
        System.out.println(("泛型测试" + "key value is " + obj.getKey()));
    }

    public static void main(String[] args) {
        Generic<Integer> generic = new Generic<Integer>(123);
        Generic<Number> generic1 = new Generic<Number>(123);
        Generic.showKeyValue1(generic);
        Generic.showKeyValue1(generic1);
    }
}
