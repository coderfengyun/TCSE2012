public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
			return false;
		}
		int count = calculateDecimalCount(x);
		int leftPosition = 0, rightPosition = count - 1;
		while (leftPosition < rightPosition) {
			if (getValueOn(leftPosition, x) != getValueOn(
					rightPosition, x)) {
				return false;
			}
			leftPosition++;
			rightPosition--;
		}
		return true;
	}

	private int calculateDecimalCount(int positiveNumber) {
		int result = 0, quotient = positiveNumber;
		while (quotient > 0) {
			quotient = quotient / 10;
			result++;
		}
		return result;
	}

	private int getValueOn(int position, int target) {
		while (position > 0) {
			target = target / 10;
			position--;
		}
		return target % 10;
	}
}