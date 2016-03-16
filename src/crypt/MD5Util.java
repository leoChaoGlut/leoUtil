package crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static final String ALROGITHM = "MD5";

	public static byte[] build(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance(ALROGITHM);
			return md.digest(src.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String bytesToHex(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		int digital = 0;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];
			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				result.append("0");
			}
			result.append(Integer.toHexString(digital));
		}
		return result.toString();
	}
}
