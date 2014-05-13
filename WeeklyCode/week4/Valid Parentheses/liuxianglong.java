class liuxianglong {
	private boolean match(Stack<Character> stack,char c){
		switch(c){
		case '{': 
		case '(':
		case '[':stack.add(c);return true;
		case '}':return stack.size()>0&&stack.pop().equals('{');
		case ')':return stack.size()>0&&stack.pop().equals('(');
		case ']':return stack.size()>0&&stack.pop().equals('[');
		default : return false;
		}
	}
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(char c:s.toCharArray()) if (!match(stack, c)) return false;
		return stack.isEmpty();
	}
}