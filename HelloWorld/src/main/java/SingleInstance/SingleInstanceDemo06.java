package SingleInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum SingleInstanceDemo06 {
    INSTANCE;

    public SingleInstanceDemo06 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingleInstanceDemo06 instance = SingleInstanceDemo06.INSTANCE;
        System.out.println(instance);
        Constructor<SingleInstanceDemo06> declaredConstructor = SingleInstanceDemo06.class
                .getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        SingleInstanceDemo06 singleInstanceDemo06 = declaredConstructor.newInstance();
        System.out.println(singleInstanceDemo06);
    }
}
