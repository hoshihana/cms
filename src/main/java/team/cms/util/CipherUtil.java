package team.cms.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public class CipherUtil {

    final static String ALGORITHM = "AES";

    final static String KEY_SEED = "NCUJAVAWEB";

    final static String CHARACTER_SET = "utf-8";

    // 根据种子生成密匙
    public static Key generateKey(String keySeed) {
        try {
            // 手动指定 SecureRandom 随机数生成规则，保证每次生成相同的key
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(keySeed.getBytes());
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(128, secureRandom);
            return keyGenerator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 加密明文
    public static String encipherText(String plainText) {
        byte[] cipherText;
        Key key = generateKey(KEY_SEED);
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(plainText.getBytes(CHARACTER_SET));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 解密密文
    public static String decipherText(String cipherText) {
        byte[] plainText;
        Key key = generateKey(KEY_SEED);
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
            return new String(plainText, CHARACTER_SET);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
