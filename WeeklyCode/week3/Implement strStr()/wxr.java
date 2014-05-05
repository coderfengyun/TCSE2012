public class Solution {
  public String strStr(String haystack, String needle) {

		if (haystack == null || needle == null) {
			return null;
		}
		if (haystack.length() < needle.length()) {
			return null;
		}

		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {

			if (isEqual(haystack, i, needle)) {
				return haystack.substring(i);
			}

		}
		return null;

	}

	private boolean isEqual(String haystact, int begin, String needle) {
		for (int i = 0; i < needle.length(); i++) {
			if (haystact.charAt(i + begin) != needle.charAt(i)) {
				return false;
			}

		}
		return true;
	}

}