public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;
        ListNode head = new ListNode((l1.val + l2.val)%10);
        ListNode result = head;
        int currentCarry = (l1.val + l2.val) / 10, temp = 0;
        for(;l1.next != null || l2.next!= null;)
        {
            if(l1.next ==null)
            {
                l2 = l2.next;
                temp = l2.val + currentCarry;
            }
            else if(l2.next == null) {
                l1 = l1.next;
                temp = l1.val + currentCarry;
            }
            else{
                l1 = l1.next;
                l2 = l2.next;
                temp = l1.val + l2.val + currentCarry;
            }
            head.next = new ListNode(temp % 10);
            currentCarry = temp / 10;
            head = head.next;
        }
        if(currentCarry > 0) head.next = new ListNode(currentCarry);
        return result;
    }
}