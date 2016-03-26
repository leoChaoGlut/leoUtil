package test;

import org.junit.Test;

import crypt.AESUtil;
import crypt.MD5Util;
import sql.SQLBuilder;

public class MyTest {
	@Test
	public void test() {
		String src = "chashaobao";
		byte[] build = MD5Util.build(src);
		String bytesToHex = MD5Util.bytesToHex(build);
		System.out.println(bytesToHex);
	}

}
