public class Solution {
    public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return "";
		}
		String result = "";
		for (int i = num1.length() - 1; i >= 0; i--) {
			String partResult = multiplyWith(num1.charAt(i), num1.length() - i
					- 1, num2);
			result = add(result, partResult);
		}
		return result.charAt(0) == '0' ? "0" : result;
	}

	private String add(String partner1, String partner2) {
		if (partner1.isEmpty()) {
			return partner2;
		}
		if (partner2.isEmpty()) {
			return partner1;
		}
		int indexOfPartner1 = partner1.length() - 1, indexOfPartner2 = partner2
				.length() - 1;
		int carry = 0;
		String result = "";
		while (indexOfPartner1 >= 0 && indexOfPartner2 >= 0) {
			DigitResult digitResult = DigitResult.Add(
					partner1.charAt(indexOfPartner1),
					partner2.charAt(indexOfPartner2), carry);
			result = digitResult.digitValue + result;
			carry = digitResult.carryValue;
			indexOfPartner1--;
			indexOfPartner2--;
		}

		for (int i = indexOfPartner1; i >= 0; i--) {
			DigitResult digitResult = DigitResult.Add('0', partner1.charAt(i),
					carry);
			result = digitResult.digitValue + result;
			carry = digitResult.carryValue;
		}
		for (int i = indexOfPartner2; i >= 0; i--) {
			DigitResult digitResult = DigitResult.Add('0', partner2.charAt(i),
					carry);
			result = digitResult.digitValue + result;
			carry = digitResult.carryValue;
		}
		if (carry > 0) {
			result = carry + result;
		}
		return result;
	}

	private String multiplyWith(char charValueOfDigit, int multiplierPosition,
			String multiplicant) {
		int carry = 0;
		String result = "";
		for (int i = multiplicant.length() - 1; i >= 0; i--) {
			DigitResult digitResult = DigitResult.Multiply(charValueOfDigit,
					multiplicant.charAt(i), carry);
			result = digitResult.digitValue + result;
			carry = digitResult.carryValue;
		}
		if (carry > 0) {
			result = carry + result;
		}
		for (int i = 0; i < multiplierPosition; i++) {
			result += '0';
		}
		return result;
	}

	private static int toInt(char ch) {
		return ch - '0';
	}

	private static class DigitResult {
		public final int digitValue;
		public final int carryValue;

		private DigitResult(int calculateResult) {
			this.digitValue = calculateResult % 10;
			this.carryValue = calculateResult / 10;
		}

		private static DigitResult Add(char partner1, char partner2, int carry) {
			int digitOfPartner1 = toInt(partner1), digitOfPartner2 = toInt(partner2);
			int calculateResult = digitOfPartner1 + digitOfPartner2 + carry;
			return new DigitResult(calculateResult);
		}

		private static DigitResult Multiply(char partner1, char partner2,
				int carry) {
			int digitOfPartner1 = toInt(partner1), digitOfPartner2 = toInt(partner2);
			int calculateResult = digitOfPartner1 * digitOfPartner2 + carry;
			return new DigitResult(calculateResult);
		}
	}
}