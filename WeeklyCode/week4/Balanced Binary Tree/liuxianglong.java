class liuxianglong {
	private int checkHeight(TreeNode root){
		if(root==null) return 0;
		int leftHeight = checkHeight(root.left)+1;
		int rightHeight = checkHeight(root.right)+1;
		if(leftHeight==0||rightHeight==0) return -1;
		if(Math.abs(leftHeight-rightHeight)>1) return -1;
		return leftHeight>rightHeight?leftHeight:rightHeight;
	}
	public boolean isBalanced(TreeNode root){
		return checkHeight(root)!=-1;
	}
}