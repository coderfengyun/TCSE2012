class liuxianglong {
	public ListNode sortList(ListNode head) {
        if(head==null||head.next ==null) return head;
        ListNode vHead = new ListNode(-1);ListNode cur = vHead;
        ListNode fast = head;ListNode slow = fast;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = sortList(slow.next);
        slow.next=null;
        slow = sortList(head);
        while(slow!=null&fast!=null){
            if(slow.val<fast.val){
                cur.next = slow;
                slow = slow.next;
            }else{
                cur.next = fast;
                fast = fast.next;
            }
            cur = cur.next;
        }
        if(slow==null){
            cur.next = fast;
        }else{
            cur.next = slow;
        }
        return vHead.next;
    }
}