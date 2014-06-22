public class Solution {
    private static final char FALSE = 'F';
	private static final char TRUE = 'T';
	private static final char NOT_INITIAL = 'N';
	private String s1;
	private String s2;
	private char[][][] memo;

	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		this.s1 = s1;
		this.s2 = s2;
		int length = s1.length();
		this.memo = new char[length][length][length + 1];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				for (int k = 0; k < length + 1; k++) {
					if (k == 1) {
						this.memo[i][j][k] = this.s1.charAt(i) == this.s2
								.charAt(j) ? TRUE : FALSE;
					} else {
						this.memo[i][j][k] = NOT_INITIAL;
					}
				}
			}
		}
		return isScramble0(0, 0, length);
	}

	private boolean isScramble0(int indexOfS1, int indexOfS2, int length) {
		if (this.memo[indexOfS1][indexOfS2][length] != NOT_INITIAL) {
			return this.memo[indexOfS1][indexOfS2][length] == TRUE;
		}
		boolean result = false;
		for (int i = indexOfS1 + 1; i < indexOfS1 + length; i++) {
			// not scramb
			boolean unScramResult = isScramble0(indexOfS1, indexOfS2, i
					- indexOfS1)
					&& isScramble0(i, indexOfS2 + i - indexOfS1, length
							- (i - indexOfS1));

			boolean scramResult = isScramble0(indexOfS1, indexOfS2 + length
					- (i - indexOfS1), i - indexOfS1)
					&& isScramble0(i, indexOfS2, length - (i - indexOfS1));
			if (unScramResult || scramResult) {
				result = true;
			}
		}
		this.memo[indexOfS1][indexOfS2][length] = result ? TRUE : FALSE;
		return result;
	}
}