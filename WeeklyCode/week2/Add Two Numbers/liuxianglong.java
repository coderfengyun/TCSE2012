class liuxianglong {
	public ListNode addTwoNumbersWithCarry(int carry, ListNode l1, ListNode l2){
		if(l1==null&&l2==null&&carry==0) return null;
		int val1=0;int val2=0;
		if(l1!=null){
			val1 = l1.val;
			l1= l1.next;
		}
		if(l2!=null){
			val2 = l2.val;
			l2 = l2.next;
		}
		int sum = carry+val1+val2;
		ListNode newBit = new ListNode(sum%10);
		newBit.next = addTwoNumbersWithCarry(sum/10, l1, l2);
		return newBit;
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersWithCarry(0, l1, l2);
    }
}