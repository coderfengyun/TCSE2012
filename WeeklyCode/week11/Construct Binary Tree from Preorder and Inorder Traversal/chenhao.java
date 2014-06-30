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
    
    int[] pre,in;
    
    private TreeNode build(int p,int i,int len){
        if(len<=0){
            return null;
        }
        TreeNode root=new TreeNode(pre[p]);
        int leftLen=0;
        while(in[i+leftLen]!=pre[p]){
            leftLen++;
        }
        root.left=build(p+1,i,leftLen);
        int rightLen=len-1-leftLen;
        root.right=build(p+1+leftLen,i+1+leftLen,rightLen);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre=preorder;
        this.in=inorder;
        return build(0,0,preorder.length);
    }
}