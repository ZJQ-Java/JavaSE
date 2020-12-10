package SingleInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum SingleInstanceEnum {
    INSTANCE;

    public SingleInstanceEnum getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingleInstanceEnum instance = SingleInstanceEnum.INSTANCE;
        System.out.println(instance);
        Constructor<SingleInstanceEnum> declaredConstructor = SingleInstanceEnum.class
                .getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        SingleInstanceEnum singleInstanceDemo06 = declaredConstructor.newInstance();
        System.out.println(singleInstanceDemo06);
    }
}
