package CacheUtil;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {
    private static RemovalListener<Object, Object> removalListener =
            removal -> System.out.println(" [" + removal.getKey() + "]被移除原因是 [" + removal.getCause() + "] ");
    public static  LoadingCache<Object, Object>    localCache      = CacheBuilder.newBuilder().initialCapacity(2)
            .maximumSize(3)
            .expireAfterAccess(3, TimeUnit.SECONDS)
//            .expireAfterWrite(3, TimeUnit.SECONDS)
            .removalListener(removalListener)
            .build(new CacheLoader<Object, Object>() {
                @Override
                public Object load(Object o) throws Exception {
                    return null;
                }
            });

    public static void setKey(Object key, Object value) {
        localCache.put(key, value);
        System.out.println("[{}]缓存成功" + key);
    }

    public static Object getKey(Object key, Object defultValue) {
        try {
            return localCache.get(key);
        } catch (ExecutionException e) {
            System.out.println("获取缓存异常" + e);
        } catch (CacheLoader.InvalidCacheLoadException e) {
            System.out.println("没有从缓存中获取到数据，返回为null----");
        }
        return defultValue;
    }

    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("name", "xsh");
        map.put("age", "23");
        map.put("gender", "male");
    }

    public static String getValue(String key) {
        String result;
        if ((getKey(key, null)) == null) {
            setKey(key, map.get(key));
            result = map.get(key);
        } else {
            result = (String) getKey(key, null);
            System.out.println("从缓存中获取[" + key + "]的值为:[" + result + "]");
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            getValue("name");
            getValue("age");
            getValue("gender");
            Thread.sleep(2000);
        }
        Thread.sleep(5000);
        for (int i = 0; i < 3; i++) {
            getValue("name");
            getValue("age");
            getValue("gender");
            Thread.sleep(3000);
        }
    }
}
