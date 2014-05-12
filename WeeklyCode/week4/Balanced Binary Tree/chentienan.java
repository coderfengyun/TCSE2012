/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private static int NOT_BALANCED_FLAG = -1;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return getHeightIfBalaced(root) != NOT_BALANCED_FLAG;
    }

    private boolean isMeetBalanceRestriction(int leftHeight, int rightHeight){
        if(leftHeight == NOT_BALANCED_FLAG || rightHeight == NOT_BALANCED_FLAG){
            return false;
        }
        int greater = getLarger(leftHeight, rightHeight);
        int lesser = leftHeight < rightHeight ? leftHeight : rightHeight;
        return greater - lesser <= 1;
    }
    
    //If not balanced tree return NOT_BALANCED_FLAG
    private int getHeightIfBalaced(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = getHeightIfBalaced(node.left);
        int rightHeight = getHeightIfBalaced(node.right);
        if(!isMeetBalanceRestriction(leftHeight, rightHeight)){
            return NOT_BALANCED_FLAG;
        }
        return getLarger(leftHeight, rightHeight) + 1;
    }
    
    private int getLarger(int leftHeight, int rightHeight){
        return (leftHeight > rightHeight ? leftHeight : rightHeight);
    }
}