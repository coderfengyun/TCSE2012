public class Solution {
     Map<String, Integer> footPrints = new HashMap<String, Integer>();
	private int minResult = Integer.MAX_VALUE;

	public int ladderLength(String start, String end, Set<String> dict) {
		return ladderLength0(start, end, dict, 0);
	}

	private int ladderLength0(String start, String end, Set<String> dict,
			int swapTimes) {
		int result = Integer.MAX_VALUE;
		String temp = null;
		if (start == null || end == null || start.length() != end.length()) {
			throw new RuntimeException();
		}
		if (start.equals(end)) {
			this.minResult = Math.min(swapTimes + 1, this.minResult);
			return 1;
		}
		if (swapTimes + 1 > this.minResult) {
			return result;
		}
		if (!dict.contains(end)) {
			dict.add(end);
		}
		footPrints.put(start, swapTimes);
		for (int i = 0; i < end.length(); i++) {
			for (char c = 'a'; c < 'z'; c++) {
				temp = buildNewStart(start, i, c);
				if (temp.equals(start)) {
					continue;
				}
				if (footPrints.keySet().contains(temp)
						&& footPrints.get(temp) <= swapTimes) {
					continue;
				}
				if (dict.contains(temp)) {
					footPrints.put(temp, swapTimes + 1);
					if (swapTimes > result) {
						continue;
					}
					int upperResult = ladderLength0(temp, end, dict,
							swapTimes + 1);
					if (upperResult == 0) {
						// 0 as failure
						continue;
					} else {
						result = Math.min(result, upperResult + 1);
					}
				}
			}
		}
		return result == Integer.MAX_VALUE ? 0 : result;
	}

	private String buildNewStart(String toBeChanged, int index, char replace) {
		return toBeChanged.substring(0, index) + replace
				+ toBeChanged.substring(index + 1);
	}
}