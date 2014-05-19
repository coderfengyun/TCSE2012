public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(isLeaf(root)){
            return 1;
        }
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        if(leftMinDepth == 0 && rightMinDepth != 0){
            return rightMinDepth + 1;
        }else if(leftMinDepth != 0 && rightMinDepth == 0){
            return leftMinDepth + 1;
        }
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }
    
    private boolean isLeaf(TreeNode underTest){
        return underTest.left == null && underTest.right == null;
    }
}