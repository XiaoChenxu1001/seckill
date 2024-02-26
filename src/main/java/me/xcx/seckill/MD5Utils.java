package me.xcx.seckill;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;
import java.util.Random;

public class MD5Utils {

    // 盐,和前端保持统一
    private static final String SALT = "1a2b3c4d";

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    // 保持和前端一致; 为了安全性做混淆
    public static String plaintextToCiphertext(String plaintext) {
        return md5("" + SALT.charAt(0) + SALT.charAt(2) + plaintext + SALT.charAt(5) + SALT.charAt(4));
    }

    // 二次混淆加密；随机盐；存储到数据库；对比密文
    public static String plaintextToCiphertext(String plaintext, String salt) {
        return md5("" + salt.charAt(0) + salt.charAt(2) + plaintext + salt.charAt(5) + salt.charAt(4));
    }


    private static final char[] ALL_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    // SecureRandom是一个加密安全的随机数生成器，它通常比java.util.Random更适合生成密码学相关的随机数。
    private static final SecureRandom random = new SecureRandom();
    private static final int SALT_LENGTH = 6;
    public static String randomSalt() {
        // StringBuffer 线程安全; StringBuilder速度更快; 多个线程共享实例才会出现问题
        StringBuilder salt = new StringBuilder(SALT_LENGTH);
        for (int i = 0; i < SALT_LENGTH; i++) {
            int index = random.nextInt(ALL_CHARS.length);
            salt.append(ALL_CHARS[index]);
        }
        return salt.toString();
    }

    // 测试
    public static void main(String[] args) {
        String password = "123456";
        String salt = "1a2b3c4d";
        String ciphertext = plaintextToCiphertext(password);
        System.out.println(ciphertext);
        String db = plaintextToCiphertext(ciphertext, salt);
        System.out.println(db);

        for (int i = 0; i < 10; i++) {
            System.out.println(randomSalt());
        }
    }


}
