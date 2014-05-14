class liuxianglong {
	private boolean dfs(TreeNode root, int sum){
        if(root.left==null&&root.right==null){
            return root.val==sum;
        }else{
            int newSum = sum-root.val;
            return (root.left!=null&&dfs(root.left,newSum))||(root.right!=null&&dfs(root.right,newSum));
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        return dfs(root,sum);
    }
}