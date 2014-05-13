package test;

public class StringToInteger {
	private boolean sign;

	public int atoi(String str) {

		int result = 0;
		long resultLong = 0;
		str = preprocess(str);
		if (str.isEmpty()) {
			return 0;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				if (i == 0) {
					return 0;
				} else {
					str = str.substring(0, i);
				}
				break;
			}
		}
		resultLong = Long.parseLong(str);
		if (sign) {
			if (resultLong >= Integer.MAX_VALUE) {
				result = Integer.MAX_VALUE;
			} else {
				result = Integer.parseInt(str);
			}
		}
		if (!sign) {
			resultLong = -resultLong;
			if (resultLong <= Integer.MIN_VALUE) {
				result = Integer.MIN_VALUE;
			} else {
				result = -Integer.parseInt(str);
			}
		}
		return result;
	}

	private String preprocess(String str) {
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == ' ') {
				continue;
			} else {
				str = str.substring(i);
				break;
			}
		}
		if (str.startsWith("-")) {
			sign = false;
			str = str.substring(1);
		} else if (str.startsWith("+")) {
			sign = true;
			str = str.substring(1);

		} else {
			sign = true;
		}
		return str;
	}
}
