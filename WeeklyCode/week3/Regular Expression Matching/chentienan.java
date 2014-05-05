class Solution{
    public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		if (p.length() == 0 || s.length() == 0) {
			return true;
		}
		List<RegularPart> regularParts = getRegularParts(p);
		List<StartPointRange> startPointRanges = buildOneItemList(new StartPointRange(
				0, 0));
		for (int i = 0; i < regularParts.size(); i++) {
			startPointRanges = matchForNextStartRanges(s, startPointRanges,
					regularParts.get(i));
			if (startPointRanges.size() == 0) {
				return false;
			}
		}
		if (startPointRanges.get(startPointRanges.size() - 1).end != s.length()) {
			return false;
		}
		return true;
	}

	private List<StartPointRange> matchForNextStartRanges(String toBeMatched,
			List<StartPointRange> startPointRanges, RegularPart regularPart) {
		List<StartPointRange> resut = new ArrayList<StartPointRange>();
		for (StartPointRange startRange : startPointRanges) {
			resut.addAll(matchForNextStartRange(toBeMatched, startRange,
					regularPart));
		}
		return resut;
	}

	private List<StartPointRange> matchForNextStartRange(String toBeMatched,
			StartPointRange thisRange, RegularPart regularPart) {
		int matchedIndex = -1;
		List<StartPointRange> result = new ArrayList<StartPointRange>();
		if (!regularPart.hasAsterisk) {
			if (regularPart.regularContent.equals(".")) {
				return buildOneItemList(new StartPointRange(
						thisRange.begin + 1, thisRange.end + 1));
			}
			matchedIndex = toBeMatched.indexOf(regularPart.regularContent,
					thisRange.begin);
			if (matchedIndex == -1 || matchedIndex > thisRange.end + 1) {
				return result;
			} else {
				return buildOneItemList(new StartPointRange(matchedIndex + 1,
						matchedIndex + regularPart.regularContent.length()));
			}

		} else {
			if (regularPart.regularContent.equals(".")) {
				return buildOneItemList(new StartPointRange(thisRange.begin,
						toBeMatched.length()));
			} else {
				matchedIndex = toBeMatched.indexOf(regularPart.regularContent,
						thisRange.begin);
				if (matchedIndex == -1 || matchedIndex > thisRange.end) {
					return buildOneItemList(thisRange);
				} else {
					int firstIndex = -1, secondIndex = -1;
					for (int i = thisRange.begin; i < toBeMatched.length(); i++) {
						if (toBeMatched.charAt(i) == regularPart.regularContent
								.charAt(0)) {
							if (firstIndex == -1) {
								firstIndex = i;
							}
						} else {
							if (firstIndex == -1) {
								continue;
							}
							secondIndex = i - 1;
							result.add(new StartPointRange(firstIndex,
									secondIndex + 1));
							firstIndex = -1;
							secondIndex = -1;
							if (i > thisRange.end) {
								break;
							}
						}
					}
					if (firstIndex > -1 && secondIndex == -1) {
						result.add(new StartPointRange(firstIndex, toBeMatched
								.length()));
					}
					return result;
				}
			}
		}
	}

	private List<StartPointRange> buildOneItemList(
			StartPointRange startPointRange) {
		List<StartPointRange> result = new ArrayList<StartPointRange>();
		result.add(startPointRange);
		return result;
	}

	/**
	 * It do it in a reverse way
	 * 
	 * @param regularExpression
	 * @return
	 */

	private List<RegularPart> getRegularParts(String regularExpression) {
		List<RegularPart> result = new ArrayList<RegularPart>();
		if (regularExpression == null || regularExpression.isEmpty()) {
			return result;
		}
		int index = regularExpression.length() - 1;
		char[] array = regularExpression.toCharArray();
		StringBuffer temp = new StringBuffer();
		for (; index >= 0; index--) {
			if (array[index] == '*') {
				if (index == 0) {
					temp.append(array[index]);
				} else {
					if (temp.length() != 0) {
						result.add(new RegularPart(temp.toString(), false));
						temp.delete(0, temp.length());
					}
					result.add(new RegularPart(new String(
							new char[] { array[index - 1] }), true));
					index--;
				}
			} else if (array[index] == '.') {
				if (temp.length() != 0) {
					result.add(new RegularPart(temp.toString(), false));
					temp.delete(0, temp.length());
				}
				result.add(new RegularPart(new String(
						new char[] { array[index] }), false));
			} else {
				temp.append(array[index]);
			}
		}
		if (temp.length() > 0) {
			result.add(new RegularPart(temp.toString(), false));
		}
		Collections.reverse(result);
		return result;
	}

	static class StartPointRange {
		int begin;
		int end;

		StartPointRange() {
			StartPointRange.this.begin = -1;
			StartPointRange.this.end = -1;
		}

		StartPointRange(int begin, int end) {
			StartPointRange.this.begin = begin;
			StartPointRange.this.end = end;
		}

		public boolean isValid() {
			return StartPointRange.this.begin != -1
					&& StartPointRange.this.end != -1;
		}
	}

	static class RegularPart {
		public String regularContent;
		public boolean hasAsterisk;

		RegularPart(String content, boolean hasAsterisk) {
			this.regularContent = content;
			this.hasAsterisk = hasAsterisk;
		}

		public boolean containDot() {
			return regularContent.indexOf('.') != -1;
		}
	}
}