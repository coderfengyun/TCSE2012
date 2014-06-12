class liuxianglong {
	private void dfsWordBreak(String s, boolean seg[][], int start,
			ArrayList<String> ret, StringBuilder sb, Set<String> dict) {
		if (s.equals("")) {
			ret.add(sb.substring(0, sb.length() - 1));
		}
		for (int len = 1; len <= s.length(); len++) {
			if (seg[start][len]) {
				String str = s.substring(0, len);
				if (dict.contains(str)) {
					sb.append(str).append(" ");
					dfsWordBreak(s.substring(len), seg, start + len, ret, sb, dict);
					sb.delete(sb.length() - str.length() - 1, sb.length());
				}
			}
		}
	}
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result= new ArrayList<String>();
		if (s.equals("")) return result;
		boolean seg[][] = new boolean[s.length()][s.length() + 1];
		for (int len = 1; len <= s.length(); len++) {
			for (int i = 0; i < s.length(); i++) {
				if (i + len <= s.length()) {
					if (dict.contains(s.substring(i, i + len))) {
						seg[i][len] = true;
						continue;
					}
					for (int k = 1; k < len; k++) {
						if (seg[i][k] && seg[i + k][len - k]) {
							seg[i][len] = true;
							break;
						}
					}
				}
			}
		}
		if (!seg[0][s.length()])
			return result;
		dfsWordBreak(s, seg, 0, result, new StringBuilder(), dict);
		return result;
	}
}