package week10;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x < 10)
			return true;
		long reverseNumber = 0;
		int tmp = x;
		while (tmp != 0) {
			reverseNumber = reverseNumber * 10 + tmp % 10;
			tmp = tmp / 10;
		}
		if (reverseNumber == Long.valueOf(x)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		PalindromeNumber isP = new PalindromeNumber();
		System.out.println(isP.isPalindrome(11));
	}
}
