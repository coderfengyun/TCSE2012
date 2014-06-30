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
    
    TreeNode pre;
    TreeNode node1,node2;
    
    void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        if(root.val<pre.val){
            if(node1==null){
                node1=pre;
                node2=root;
            }
            else{
                node2=root;
            }
        }
        pre=root;
        dfs(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        pre=new TreeNode(Integer.MIN_VALUE);
        node1=node2=null;
        dfs(root);
        int tmp=node1.val;
        node1.val=node2.val;
        node2.val=tmp;
    }
}