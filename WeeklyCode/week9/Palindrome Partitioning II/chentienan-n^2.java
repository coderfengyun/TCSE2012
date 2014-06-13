public class Solution {
   public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[] minCuts = initialMinCuts(n + 1);
		boolean[][] isPalindrome = initialIsPalindromes(n);
		for (int begin = n - 1; begin >= 0; begin--) {
			for (int end = begin; end < n; end++) {
				if (isPalindrome(s, begin, end, isPalindrome)) {
					isPalindrome[begin][end] = true;
					minCuts[begin] = Math.min(minCuts[begin],
							minCuts[end + 1] + 1);
				}
			}
		}
		return minCuts[0];
	}

	private int[] initialMinCuts(int size) {
		int[] minCuts = new int[size];
		for (int i = 0; i < size; i++) {
			minCuts[i] = size - i - 2;
		}
		return minCuts;
	}

	private boolean[][] initialIsPalindromes(int n) {
		boolean[][] isPalindrome = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				isPalindrome[i][j] = i == j;
			}
		}
		return isPalindrome;
	}

	// This begin and end are inclusive
	private boolean isPalindrome(String s, int begin, int end,
			boolean[][] isPalindrome) {
		boolean result = false;
		if (end - begin == 0) {
			result = true;
		} else if (end - begin == 1) {
			result = s.charAt(begin) == s.charAt(end);
		} else {
			result = s.charAt(begin) == s.charAt(end)
					&& isPalindrome[begin + 1][end - 1];
		}
		return result;
	}
}