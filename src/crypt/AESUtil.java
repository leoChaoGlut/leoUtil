package crypt;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author leo
 * @date 2016年3月16日 下午7:37:48
 * @description
 * @usage 1.加密/解密 调用 doCrypt; 2.若想以string形式输出加密后的byte,则调用convertBytesToHexString
 * 
 */
public class AESUtil {
	public static final int KEY_SIZE = 128;

	public static final String ALGORITHM = "AES";

	/**
	 * 
	 * @param src
	 *            需要转换的byte[]
	 * @param key
	 *            秘钥
	 * @param isEncrypt
	 *            true?encrypt:decrypt
	 * @return 转换后的byte[]
	 */
	public static byte[] doCrypt(byte[] src, String key, boolean isEncrypt) {
		try {
			KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
			SecureRandom sr = new SecureRandom(key.getBytes());
			kg.init(KEY_SIZE, sr);
			SecretKey sk = kg.generateKey();
			byte[] encoded = sk.getEncoded();
			SecretKeySpec sks = new SecretKeySpec(encoded, ALGORITHM);
			Cipher c = Cipher.getInstance(ALGORITHM);
			int encryptMode = isEncrypt ? Cipher.ENCRYPT_MODE
					: Cipher.DECRYPT_MODE;
			c.init(encryptMode, sks);
			return c.doFinal(src);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将byte数组转换为16进制字符串,如果直接用new String(byte)这样的方法输出的是乱码.
	 * 
	 * @param bytes
	 *            加密某个string后得到的byte[]
	 * @return
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			int temp = bytes[i] & 0xff;
			String tempHex = Integer.toHexString(temp);
			if (tempHex.length() < 2) {
				result.append("0" + tempHex);// 小于10的话补0
			} else {
				result.append(tempHex);
			}
		}
		return result.toString();
	}
}
