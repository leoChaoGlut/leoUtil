package string;

import java.util.Random;

/**
 * @Author: Leo
 * @Blog: http://blog.csdn.net/lc0817
 * @CreateTime: 2016/11/5 13:07
 * @Description:
 */
public class StringUtil {
    static char[] NUMBER_AND_LETTER = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    };

    public static String random(int length) {
        char[] randomChars = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            randomChars[i] = NUMBER_AND_LETTER[random.nextInt(NUMBER_AND_LETTER.length)];
        }
        return new String(randomChars);
    }
}
