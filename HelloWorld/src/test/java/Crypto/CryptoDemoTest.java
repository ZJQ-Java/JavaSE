package Crypto;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;


public class CryptoDemoTest {
    @Test
    public void urlTest() {
        try {
            String encode = URLEncoder.encode("中！", "UTF-8");
            System.out.println(encode);
            String decode = URLDecoder.decode(encode, "UTF-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void base64Test() {
        //24位3字节 变 32位4字节 不够自动补0x00（=）
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println(b64encoded);
        System.out.println(b64encoded2);
        byte[] output = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void MD5Test() {
        //
        try {
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            md5Digest.update("Hello World".getBytes(StandardCharsets.UTF_8));
            byte[] digest = md5Digest.digest();
            System.out.println(new BigInteger(1, digest).toString(16));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void hmacMd5Test() {
        try {
            //encode
            KeyGenerator hmacMD5 = KeyGenerator.getInstance("HmacMD5");
            SecretKey secretKey = hmacMD5.generateKey();
            byte[] encodedByte = secretKey.getEncoded();
            System.out.println(new String(encodedByte));
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(secretKey);
            mac.update("Hello World".getBytes(StandardCharsets.UTF_8));
            byte[] bytes = mac.doFinal();
            System.out.println(new BigInteger(1, bytes).toString(16));

            //decode
            /*SecretKey decodeSecret = new SecretKeySpec(encodedByte,"HmacMD5");
            Mac decodeMac = Mac.getInstance("HmacMD5");
            decodeMac.init(decodeSecret);
            decodeMac.update("Hello World".getBytes(StandardCharsets.UTF_8));
            byte[] bytes1 = decodeMac.doFinal();
            String s = Arrays.toString(bytes1);
            System.out.println(s);*/
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AESTest() throws GeneralSecurityException {
        byte[] key = "1234567890abcdef".getBytes();
        byte[] bytes = "hello World".getBytes();
        byte[] encrypt = encrypt(key, bytes);
        System.out.println(Base64.getEncoder().encodeToString(encrypt));
        System.out.println(new String(decrypt(key, encrypt)));
    }

    // 加密:
    private static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }

    // 解密:
    private static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }

}