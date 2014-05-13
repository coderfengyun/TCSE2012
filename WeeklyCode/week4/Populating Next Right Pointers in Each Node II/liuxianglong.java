class liuxianglong {
	public void connect(TreeLinkNode root) {
        if(root==null) return;
		TreeLinkNode head = new TreeLinkNode(0);
		TreeLinkNode cur = head;
		while(root!=null){
			if(root.left!=null){
				cur.next = root.left;
				cur= cur.next;
			}
			if(root.right!=null){
				cur.next = root.right;
				cur= cur.next;
			}
			root = root.next;
		}
		connect(head.next);
    }
}