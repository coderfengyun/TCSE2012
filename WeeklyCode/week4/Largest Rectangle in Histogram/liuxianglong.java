class liuxianglong {
	public int largestRectangleArea(int[] height) {
        if(height==null||height.length==0) return 0;
        Stack<Integer> startStack= new Stack<Integer>();
        Stack<Integer> heightStack = new Stack<Integer>();
        int max = 0;int len = height.length;
        for(int i=0;i<len;i++){
        	int start = i;
        	while(!heightStack.empty()&&height[i]<heightStack.peek()){
        		int index = startStack.pop();
        		int area= (i-index)*heightStack.pop();
        		if(area>max) max = area;
        		start = index;
        	}
        	startStack.push(start);
        	heightStack.push(height[i]);
        }
        while(!heightStack.empty()){
        	int index = startStack.pop();
    		int area= (len-index)*heightStack.pop();
    		if(area>max) max = area;
        }
        return max;
    }
}