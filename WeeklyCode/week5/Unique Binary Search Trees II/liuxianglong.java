class liuxianglong {
	private TreeNode clone(TreeNode root){
        if(root==null) return null;
        TreeNode cloneRoot = new TreeNode(root.val);
        cloneRoot.left = clone(root.left);
        cloneRoot.right = clone(root.right);
        return cloneRoot;
    }
    private ArrayList<TreeNode> permute(int val,ArrayList<TreeNode> leftChilds,ArrayList<TreeNode> rightChilds){
        ArrayList<TreeNode> roots = new ArrayList<TreeNode>();
        for(TreeNode left:leftChilds){
            for(TreeNode right:rightChilds){
                TreeNode root = new TreeNode(val);
                root.left = clone(left);
                root.right =clone(right);
                roots.add(root);
            }
        }
        return roots;
    }
    private ArrayList<TreeNode> dfs(int begin,int end){
        ArrayList<TreeNode> roots = new ArrayList<TreeNode>();
        if(begin>end){
            roots.add(null);
        }else{
            for(int i=begin;i<=end;i++){
                ArrayList<TreeNode> leftChilds = dfs(begin,i-1);
                ArrayList<TreeNode> rightChilds = dfs(i+1,end);
                roots.addAll(permute(i,leftChilds,rightChilds));
            }
        }
        return roots;
    }
    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }
}