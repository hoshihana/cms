package team.cms.util;

import org.springframework.util.DigestUtils;

public class EncodeUtil {

    public static String encodeByMd5(String rawString) {
        return DigestUtils.md5DigestAsHex(rawString.getBytes());
    }
}
