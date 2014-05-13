public class Solution {
    
    private static class QueueNode{
        TreeNode node;
        int depth;
        public QueueNode(TreeNode node,int depth){
            this.node=node;
            this.depth=depth;
        }
    }
    
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<QueueNode> q=new LinkedList<>();
        q.offer(new QueueNode(root,1));
        while(!q.isEmpty()){
            QueueNode head=q.poll();
            if(head.node.left==null && head.node.right==null){
                return head.depth;
            }
            if(head.node.left!=null){
                q.offer(new QueueNode(head.node.left,head.depth+1));
            }
            if(head.node.right!=null){
                q.offer(new QueueNode(head.node.right,head.depth+1));
            }
        }
        return 0;
    }
}