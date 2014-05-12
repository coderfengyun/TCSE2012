public class Solution {
    private static final Set<Character> RIGHT = new HashSet<Character>();
	private static final Map<Character, Character> MAP = new HashMap<Character, Character>();
	static {
		RIGHT.add(')');
		RIGHT.add(']');
		RIGHT.add('}');
		MAP.put(')', '(');
		MAP.put(']', '[');
		MAP.put('}', '{');
	}

	public boolean isValid(String s) {
		if (s == null || s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (RIGHT.contains(c)) {
			    if (stack.isEmpty())
					return false;
				Character left = stack.pop();
				if (left != MAP.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty() ? true : false;
	}
}