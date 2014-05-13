public class Solution {
	public static void main(String args[]) {
		Solution solution = new Solution();
		System.out.println(solution.isMatch("bab", "b*a*"));
	}

	public boolean isMatch(String s, String p) {

		if (s == null && p == null) {
			return true;
		}
		if (s == null || p == null) {
			return false;
		}
		if (s.isEmpty() && isParttenEmpty(p)) {
			return true;
		}
		if (s.isEmpty() && !isParttenEmpty(p)) {
			return false;
		}
		if (!s.isEmpty() && p.isEmpty()) {
			return false;
		}
		if ((p.length() != s.length()) && (!p.contains("*"))) {
			return false;
		}
		if (isEqual(s.charAt(0), p.charAt(0))) {

			if (!getSubString(p, 1, 2).equals("*")) {
				return isMatch(getSubString(s, 1), getSubString(p, 1));
			} else {
				p = p.charAt(0) + getSubString(p, 2);
				if (isMatch(getSubString(s, 0), getSubString(p, 1))) {
					return true;
				}
				for (int i = 0; i < s.length(); i++) {
					if (isEqual(s.charAt(i), p.charAt(0))) {
						if (isMatch(getSubString(s, i), p)) {
							return true;
						}
					} else {
						break;
					}

				}

				return false;
			}
		} else {
			if (getSubString(p, 1, 2).equals("*")) {
				return isMatch(s, getSubString(p, 2));
			} else {
				return false;
			}
		}

	}

	private String getSubString(String s, int beginIndex, int endIndex) {
		if (beginIndex > endIndex) {
			return "";
		}
		if (beginIndex > s.length() - 1) {
			return "";
		}

		return s.substring(beginIndex, endIndex);
	}

	private String getSubString(String s, int beginIndex) {
		if (s.length() - 1 < beginIndex) {
			return "";
		} else {
			return s.substring(beginIndex);
		}
	}

	private boolean isEqual(char s, char p) {
		if (p == '.') {
			return true;
		} else if (s == p) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isParttenEmpty(String p) {

		if (p.isEmpty()) {
			return true;
		}
		if (p.length() % 2 != 0) {
			return false;
		}
		for (int i = 0; i < p.length() - 1; i = i + 2) {
			if (p.charAt(i + 1) != '*') {
				return false;
			}
		}
		return true;
	}
}