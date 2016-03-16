package test;

import org.junit.Test;

import crypt.AESUtil;
import sql.SQLBuilder;

public class MyTest {
	@Test
	public void test() {
		String key = "chashaobao";
		String src = "aaa";
		byte[] doCrypt = AESUtil.doCrypt(src.getBytes(), key, true);
		 System.out.println(AESUtil.convertBytesToHexString(doCrypt));
		System.out.println(new String(doCrypt));
		byte[] doCrypt2 = AESUtil.doCrypt(doCrypt, key, false);
		System.out.println(new String(doCrypt2));
	}

}
