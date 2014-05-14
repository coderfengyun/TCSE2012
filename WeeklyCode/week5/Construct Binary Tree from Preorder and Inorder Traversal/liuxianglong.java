class liuxianglong{
	private TreeNode findRoot(int[] preorder,int cur,int[] inorder,int begin, int end){
        if(begin>end) return null;
        int i = begin;
        while(preorder[cur]!=inorder[i])i++;
        TreeNode root = new TreeNode(preorder[cur]);
        root.left = findRoot(preorder,cur+1,inorder,begin,i-1);
        root.right= findRoot(preorder,cur+i-begin+1,inorder,i+1,end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0) return null;
        return findRoot(preorder,0,inorder,0,inorder.length-1);
    }
}