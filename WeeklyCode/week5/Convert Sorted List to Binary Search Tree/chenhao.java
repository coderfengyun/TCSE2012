
public class Solution {
    
    private int maxDepth;
    private int nNodesInLastDepth;
    
    private ListNode pList;
    
    private TreeNode buildTree(int depth){
        if(depth>=maxDepth){
            if(nNodesInLastDepth>0){
                nNodesInLastDepth--;
                return new TreeNode(0);
            }
            else{
                return null;
            }
        }
        TreeNode node=new TreeNode(0);
        node.left=buildTree(depth+1);
        node.right=buildTree(depth+1);
        return node;
    }
    
    private void assignValues(TreeNode cur){
        if(cur==null || pList==null){
            return;
        }
        assignValues(cur.left);
        cur.val=pList.val;
        pList=pList.next;
        assignValues(cur.right);
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        
        maxDepth=0;
        nNodesInLastDepth=len;
        while( nNodesInLastDepth > (1<<maxDepth) ){
            nNodesInLastDepth-=(1<<maxDepth);
            maxDepth++;
        }
        maxDepth++;
        
        TreeNode root=buildTree(1);
        
        pList=head;
        assignValues(root);
        
        return root;
    }
}