package bitManiputlation;

/**
 *
 * @anthor leo
 * @date 2016年7月4日下午3:50:55
 * @description
 *
 **/

public class BitManipulation {

	public static int add(int a, int b) {
		int result = 0;
		while (b != 0) {
			result = a ^ b;
			b = (a & b) << 1;
			a = result;
		}
		return result;
	}

	public static long add(long a, long b) {
		long result = 0;
		while (b != 0) {
			result = a ^ b;
			b = (a & b) << 1;
			a = result;
		}
		return result;
	}

}
