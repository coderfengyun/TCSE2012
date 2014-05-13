public class Solution {
    
    private boolean dfs(TreeNode cur,int sum,int curSum){
        curSum+=cur.val;
        if(cur.left==null && cur.right==null){
            return sum==curSum;
        }
        return ( cur.left!=null && dfs(cur.left,sum,curSum) ) ||
            ( cur.right!=null && dfs(cur.right,sum,curSum) );
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return dfs(root,sum,0);
    }
}