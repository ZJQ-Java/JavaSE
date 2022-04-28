package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
    public static Object getInstance(Object target){
       return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new JdkProxy(target));
    }

    public static void main(String[] args) {
        Person man = (Person)JdkProxy.getInstance(new Man());
        System.out.println(man.getSex());

    }
}

interface Person {
    public String getSex();
}

class Man implements Person {
    public String getSex() {
        return "man";
    }
}

