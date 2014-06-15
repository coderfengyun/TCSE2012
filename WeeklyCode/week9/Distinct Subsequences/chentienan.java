public class Solution {
   public int numDistinct(String S, String T) {
		if (S == null || T == null) {
			return -1;
		}
		if (S.length() <= T.length()) {
			return S.equals(T) ? 1 : 0;
		}
		int m = S.length(), n = T.length();
		int[][] result = new int[n][m];
		// i for T, j for S
		for (int j = n - 1; j >= 0; j--) {
			for (int i = m - n + j; i >= 0; i--) {
				if (j == n - 1) {
					if (i == m - 1) {
						result[j][i] = T.charAt(j) == S.charAt(i) ? 1 : 0;
					} else {
						result[j][i] = result[j][i + 1]
								+ (T.charAt(j) == S.charAt(i) ? 1 : 0);
					}
					continue;
				}
				if (result[j][i + 1] > 0) {
					if (S.charAt(i) == T.charAt(j)) {
						result[j][i] = result[j][i + 1] + result[j + 1][i + 1];
					} else {
						result[j][i] = result[j][i + 1];
					}
				} else {
					if (S.charAt(i) == T.charAt(j) && result[j + 1][i + 1] > 0) {
						result[j][i] = result[j + 1][i + 1];
					} else {
						result[j][i] = 0;
					}
				}
			}
		}
		return result[0][0];
	}
}