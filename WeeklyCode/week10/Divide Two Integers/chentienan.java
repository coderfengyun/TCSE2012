public class Solution {
    public int divide(int dividend, int divisor) {
		// I will not concern about Integer.MIN_VALUE this time;
		boolean isPositive = (dividend > 0 && divisor > 0)
				|| (dividend < 0 && divisor < 0);
		String dividentContent = String.valueOf(dividend), divisorContent = String
				.valueOf(divisor);
		long divisorValue = 0;
		if (dividentContent.charAt(0) == '-') {
			dividentContent = dividentContent.substring(1);
		}
		if (divisorContent.charAt(0) == '-') {
			divisorContent = divisorContent.substring(1);
			divisorValue = Long.valueOf(divisorContent);
		}else {
			divisorValue = divisor;
		}
		int step = divisorContent.length();
		int indexOfDividentContent = 0;
		String result = "";
		long remainder = 0;
		while (indexOfDividentContent + step <= dividentContent.length()) {
			String partialDivident = remainder
					+ dividentContent.substring(indexOfDividentContent,
							indexOfDividentContent + step);
			long partialDividentVal = Long.valueOf(partialDivident);
			if (partialDividentVal < divisorValue) {
				result += '0';
				step++;
			} else if (partialDividentVal >= divisorValue) {
				DivideResult divideResult = DivideResult.CloseDivide(
						Long.valueOf(partialDivident), divisorValue);
				remainder = divideResult.remainder;
				result += divideResult.quotient;
				indexOfDividentContent += step;
				step = 1;
			}
		}
		if (result.isEmpty()) {
			return 0;
		}
		return isPositive ? Integer.valueOf(result) : Integer.valueOf("-"
				+ result);
	}

	private static class DivideResult {
		public final int quotient;
		public final long remainder;

		private DivideResult(int quotient, long remainder) {
			this.quotient = quotient;
			this.remainder = remainder;
		}

		private static DivideResult CloseDivide(long dividend, long divisor) {
			int result = 0;
			while (dividend >= divisor) {
				dividend -= divisor;
				result++;
			}
			return new DivideResult(result, dividend);
		}

	}
}