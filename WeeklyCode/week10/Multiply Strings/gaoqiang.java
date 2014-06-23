package week10;

public class MultiplyStrings {
	public String multiplyStrings(String num1, String num2) {
		if (num1 == null || num2 == null)
			return null;
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		String a, b;
		if (num1.length() < num2.length()) {
			a = num2;
			b = num1;
		} else {
			a = num1;
			b = num2;
		}
		String result = "0";
		for (int i = b.length() - 1, times = 0; i >= 0; i--, times++) {
			int carry = 0;
			StringBuilder builder = new StringBuilder();
			for (int k = 0; k < times; k++) {
				builder.append('0');
			}
			for (int j = a.length() - 1; j >= 0; j--) {
				int r = (b.charAt(i) - '0') * (a.charAt(j) - '0') + carry;
				if (r >= 10) {
					carry = r / 10;
					r = r % 10;
				} else {
					carry = 0;
				}
				builder.append((char) (r + '0'));
			}
			if (carry > 0) {
				builder.append((char) ('0' + carry));
			}
			result = addStrings(result, builder.toString());
		}

		StringBuilder builder = new StringBuilder();
		for (int i = result.length() - 1; i >= 0; i--) {
			builder.append(result.charAt(i));
		}
		return builder.toString();
	}

	public String addStrings(String num1, String num2) {
		StringBuilder builder = new StringBuilder();
		String n1 = num1;
		String n2 = num2;
		int carry = 0, len1 = n1.length(), len2 = n2.length();
		int len = len1 > len2 ? len1 : len2;

		builder = new StringBuilder();
		for (int i = 0; i <= len - 1; i++) {
			int a = i >= len1 ? 0 : (n1.charAt(i) - '0');
			int b = i >= len2 ? 0 : (n2.charAt(i) - '0');
			int r = a + b + carry;
			if (r >= 10) {
				carry = 1;
				r = r - 10;
			} else {
				carry = 0;
			}
			builder.append((char) (r + '0'));
		}
		if (carry == 1) {
			builder.append('1');
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings s = new MultiplyStrings();
		System.out.println(s.multiplyStrings("9", "9"));
	}
}
