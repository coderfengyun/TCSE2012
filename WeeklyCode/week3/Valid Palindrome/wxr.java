package test;

public class ValidPalindrome {
	public static void main(String args[]) {
		ValidPalindrome validPalindrome = new ValidPalindrome();
		System.out.println(validPalindrome.isPalindrome("race a car"));
		System.out.println(validPalindrome
				.isPalindrome("A man, a plan, a canal: Panama"));
	}

	public boolean isPalindrome(String s) {
		if (s.isEmpty())
			return true;
		s = s.toLowerCase();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (start <= end && !validateChar(s.charAt(start))) {
				start++;
			}
			while (start <= end && !validateChar(s.charAt(end))) {
				end--;
			}
			if (start >= end) {
				break;
			}
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			} else {
				start++;
				end--;
			}
		}
		return true;
	}

	private boolean validateChar(char c) {
		if (Character.isLetter(c) || Character.isDigit(c)) {
			return true;
		} else {
			return false;
		}
	}

}
