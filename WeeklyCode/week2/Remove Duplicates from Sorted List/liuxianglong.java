class liuxianglong {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while(cur!=null){
			ListNode next = cur.next;
			while(next!=null&&next.val==cur.val)next = next.next;
			cur.next= next;
			cur = next;
		}
		return head;
    }
}