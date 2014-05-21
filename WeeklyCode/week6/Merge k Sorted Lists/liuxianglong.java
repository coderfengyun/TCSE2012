class liuxianglong {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
	    if(lists==null||lists.size()==0) return null;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
		    public int compare(ListNode o1, ListNode o2){
		        if(o1.val==o2.val) return 0;
		        return o1.val<o2.val?-1:1;
		    }
		});//1st arg at least 1
		for(ListNode node:lists){
		    if(node==null) continue;//NullPointerException
		    heap.offer(node);
		}
		ListNode head = new ListNode(-1);ListNode cur = head;
		while(heap.size()>0){
		    cur.next = heap.poll();
		    cur=cur.next;
		    if(cur.next!=null) heap.offer(cur.next);
		}
		return head.next;
    }
}