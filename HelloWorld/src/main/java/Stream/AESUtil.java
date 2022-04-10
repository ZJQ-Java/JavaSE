package Stream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AESUtil {
    private static final String registerAlgorithm = "AES/ECB/PKCS5Padding";

    private static Key key = new SecretKeySpec("".getBytes(StandardCharsets.UTF_8), "AES");

    private static Key getKey(String password) throws NoSuchAlgorithmException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
        kgen.init(128, new SecureRandom(password.getBytes()));// 利用用户密码作为随机数初始化出
        //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行
        SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }

    private static String registerEncryptAndBase64(String content) {
        try {
            Cipher cipher = Cipher.getInstance(registerAlgorithm);
            cipher.init(Cipher.ENCRYPT_MODE, getKey("11"));

            byte[] byteContent = content.getBytes("utf-8");
            byte[] result = cipher.doFinal(byteContent);
            return Base64.getUrlEncoder().encodeToString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String registerDecryptAndBase64(String content) {
        try {
            Cipher cipher = Cipher.getInstance(registerAlgorithm);
            cipher.init(Cipher.DECRYPT_MODE, getKey("11"));

            byte[] byteContent = Base64.getUrlDecoder().decode(content);
            byte[] result = cipher.doFinal(byteContent);
            return new String(result, Charset.forName("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String content = "1-" + "111-" + System.currentTimeMillis();
        System.out.println("需要加密的内容：" + content);
        String s = registerEncryptAndBase64(content);
        System.out.println(s);
        System.out.println();
        System.out.println(registerDecryptAndBase64(s));
    }
}