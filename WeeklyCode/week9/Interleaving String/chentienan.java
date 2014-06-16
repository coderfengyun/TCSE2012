public class Solution {
    private String s1;
	private String s2;
	private String s3;
	private static char NOT_INITIAL = 'N';
	private char[][] memo;

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		int lengthOfS1 = s1.length(), lengthOfS2 = s2.length(), lengthOfS3 = s3
				.length();

		this.memo = new char[lengthOfS1 + 1][lengthOfS2 + 1];
		this.memo[lengthOfS1][lengthOfS2] = 'T';
		for (int i = 0; i < lengthOfS1; i++) {
			String s1Temp = s1.substring(i);
			String s3Temp = s3.substring(i + lengthOfS2);
			this.memo[i][lengthOfS2] = s1Temp.equals(s3Temp) ? 'T' : 'F';
		}
		for (int i = 0; i < lengthOfS2; i++) {
			String s2Temp = s2.substring(i);
			String s3Temp = s3.substring(i + lengthOfS1);
			this.memo[lengthOfS1][i] = s2Temp.equals(s3Temp) ? 'T' : 'F';
		}

		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				this.memo[i][j] = NOT_INITIAL;
			}
		}
		return isInterleave0(0, 0);
	}

	private boolean isInterleave0(int indexS1, int indexS2) {
		if (this.memo[indexS1][indexS2] != NOT_INITIAL) {
			return this.memo[indexS1][indexS2] == 'T';
		}
		int indexS3 = indexS1 + indexS2;
		boolean result = false;
		if (s1.charAt(indexS1) == s2.charAt(indexS2)) {
			if (s1.charAt(indexS1) != s3.charAt(indexS3)) {
				result = false;
			} else {
				result = isInterleave0(indexS1 + 1, indexS2)
						|| isInterleave0(indexS1, indexS2 + 1);
			}
		} else if (s1.charAt(indexS1) == s3.charAt(indexS3)) {
			result = isInterleave0(indexS1 + 1, indexS2);
		} else if (s2.charAt(indexS2) == s3.charAt(indexS3)) {
			result = isInterleave0(indexS1, indexS2 + 1);
		} else {
			result = false;
		}
		this.memo[indexS1][indexS2] = result ? 'T' : 'F';
		return result;
	}
}