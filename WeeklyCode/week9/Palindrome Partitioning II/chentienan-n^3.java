public class Solution {
    public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		// In the minCuts table row is the start index and column is the end
		// index
		// (and they are both inclusive)
		// And only content upon the back diagonal will be used
		int[][] minCuts = new int[n][n];
		boolean[][] isPalindrome = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					minCuts[i][j] = 0;
					isPalindrome[i][j] = true;
				} else {
					minCuts[i][j] = -1;
					isPalindrome[i][j] = false;
				}
			}
		}
		for (int distance = 1; distance <= n - 1; distance++) {
			for (int begin = 0; begin < n - distance; begin++) {
				minCuts[begin][begin + distance] = calculateMinCut(s, begin,
						begin + distance, minCuts, isPalindrome);
			}
		}
		return minCuts[0][n - 1];
	}

	private int calculateMinCut(String s, int begin, int end, int[][] minCuts,
			boolean[][] isPalindrome) {
		int result = end - begin;
		if (isPalindrome(s, begin, end, isPalindrome)) {
			return 0;
		}
		for (int cutPoint = begin; cutPoint < end; cutPoint++) {
			result = Math.min(result, minCuts[begin][cutPoint]
					+ minCuts[cutPoint + 1][end] + 1);
		}
		return result;
	}

	// This begin and end are inclusive
	private boolean isPalindrome(String s, int begin, int end,
			boolean[][] isPalindrome) {
		boolean result = false;
		if (end - begin == 1) {
			result = s.charAt(begin) == s.charAt(end);
		} else {
			result = s.charAt(begin) == s.charAt(end)
					&& isPalindrome[begin + 1][end - 1];
		}
		isPalindrome[begin][end] = result;
		return result;
	}
}