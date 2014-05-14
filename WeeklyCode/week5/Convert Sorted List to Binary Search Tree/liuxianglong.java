class liuxianglong {
    //480ms fast
    public TreeNode sortedListToBST2(ListNode head) {
        return buildBST(head,null);
    }
    private TreeNode buildBST(ListNode head,ListNode dead){
        if(head==dead) return null;
        ListNode fast=head,slow=head;
        while(fast.next!=dead&&fast.next.next!=dead){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head,slow);
        root.right = buildBST(slow.next,dead);
        return root;
    }
    //492ms
    public TreeNode sortedListToBST1(ListNode head) {
        if(head ==null) return null;
        ListNode cur = head;
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();        
        while(cur!=null){
            TreeNode node = new TreeNode(cur.val);
            nodes.add(node);
            cur = cur.next;
        }
        return buildBST(nodes,0,nodes.size()-1);
    }
	private TreeNode buildBST(ArrayList<TreeNode> nodes, int begin, int end){
        if(begin>end) return null;
        int mid = begin+(end-begin)/2;
        TreeNode root = nodes.get(mid);
        root.left = buildBST(nodes,begin, mid-1);
        root.right = buildBST(nodes,mid+1,end);
        return root;
    }
}