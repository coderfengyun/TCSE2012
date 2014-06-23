package week10;

import java.security.InvalidParameterException;

public class DivideTwo {
	public int divide(int dividend, int divisor) {
		long a = Math.abs((long) dividend), b = Math.abs((long) divisor);
		int result = 0;
		while (a >= b) {
			long c = b;
			for (int i = 0; a >= c; i++, c <<= 1) {
				a = a - c;
				result += 1 << i;
			}
		}
		return ((dividend ^ divisor) < 0) ? (-result) : (result);
	}

	public int divide2(int dividend, int divisor) {
		if (divisor == 0) {
			throw new InvalidParameterException();
		}
		if (dividend == 0) {
			return 0;
		}
		int type = 1;
		if (dividend < 0 && divisor < 0) {
			type = 2;
		} else if (dividend < 0) {
			type = 3;
			divisor *= -1;
		} else if (divisor < 0) {
			type = 4;
			dividend *= -1;
		}
		int result = 0;
		if (type == 1) {
			while (dividend >= divisor) {
				dividend = dividend - divisor;
				result++;
			}
		} else {
			while (dividend <= divisor) {
				dividend = dividend - divisor;
				result++;
			}
		}
		if (type == 3 || type == 4) {
			result *= -1;
		}
		return result;
	}

	public static void main(String[] args) {
		DivideTwo s = new DivideTwo();
		System.out.println(s.divide(-5, 1));
	}
}
