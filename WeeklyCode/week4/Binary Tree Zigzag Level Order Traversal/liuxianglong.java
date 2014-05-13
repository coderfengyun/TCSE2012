class liuxianglong {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root==null) return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		boolean leftRight = false;
		stack.push(root);
		while(stack.size()>0){
			stack = levelTraversal(res,stack,leftRight);leftRight=!leftRight;
		}
        return res;
    }
    private Stack<TreeNode> levelTraversal(ArrayList<ArrayList<Integer>> res,Stack<TreeNode> stack, boolean leftRight) {
    	ArrayList<Integer> level = new ArrayList<Integer>();
    	Stack<TreeNode> next = new Stack<TreeNode>();
    	while(stack.size()>0){
    		TreeNode node = stack.pop();
    		level.add(node.val);
    		if(leftRight){
    			if(node.right!=null) next.push(node.right);
    			if(node.left!=null) next.push(node.left);
    		}else{
    			if(node.left!=null) next.push(node.left);
    			if(node.right!=null) next.push(node.right);
    		}
    	}
    	res.add(level);
		return next;
	}
}