class liuxianglong {
	//dfs
	public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left==0) return right+1;
        if(right==0) return left+1;
        return left>right?right+1;left+1;
    }
    //bsf
    public int minDepth2(TreeNode root) {
        if(root==null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.peek()!=null){
            depth++;
            Queue<TreeNode> curQueue = queue;
            queue = new LinkedList<TreeNode>();
            while(curQueue.peek()!=null){
                TreeNode node = curQueue.poll();
                if(node.right==null&&node.left==null) return depth;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return depth;
    }
}