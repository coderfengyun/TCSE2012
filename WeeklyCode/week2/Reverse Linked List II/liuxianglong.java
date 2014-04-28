class liuxianglong {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		ListNode cur = preHead;
		int i=1;
		for(;i<m;i++){
			cur = cur.next;
		}
		ListNode endNode = cur.next;
		ListNode beginNode = cur.next;
		for(;i<n;i++){
			ListNode tmp = beginNode;
			beginNode = endNode.next;
			endNode.next = endNode.next.next;
			beginNode.next = tmp;
		}
		cur.next = beginNode;
		return preHead.next;
    }
}