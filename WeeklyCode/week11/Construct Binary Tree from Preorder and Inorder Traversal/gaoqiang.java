public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0||preorder.length!=inorder.length){
            return null;
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if(pStart>pEnd || iStart>iEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int rIndex = -1;
        for(int i=iStart;i<=iEnd;i++){
            if(inorder[i]==preorder[pStart]){
                rIndex = i;
                break;
            }
        }
        if(rIndex!=-1){
            int leftCnt = rIndex - iStart;
            int rightCnt = iEnd - rIndex;
            root.left = buildTree(preorder, pStart+1, pStart+leftCnt, inorder, iStart, iStart+leftCnt-1);
            root.right = buildTree(preorder, pEnd-rightCnt+1, pEnd, inorder, rIndex+1, iEnd);
        }else{
            return null;
        }
        return root;
    }
}