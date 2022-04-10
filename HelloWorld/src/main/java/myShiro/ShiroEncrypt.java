package myShiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroEncrypt {
    public static void main(String[] args) {
        //加盐操作
        String password = "123456";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;  // 加密次数：2
        String alogrithmName = "md5";   // 加密算法

        String encodePassword = new SimpleHash(alogrithmName, password, salt, times).toString();

        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ",password,salt,times,encodePassword);
    }
}
