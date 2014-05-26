/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
		int totalCount = lists.size();
		int finishCount = 0;
		boolean[] finish = new boolean[totalCount];
		ListNode sentinel = new ListNode(Integer.MAX_VALUE), iterator = sentinel;
		if (totalCount == 0) {
			return null;
		}
		int minValue = Integer.MAX_VALUE, minIndex = -1;
		while (finishCount < totalCount) {
			for (int i = 0; i < lists.size(); i++) {
				ListNode node = lists.get(i);
				if (node == null) {
				    if(!finish[i]){
				        finish[i] = true;
					    finishCount++;    
				    }
					continue;
				}
				if (minValue > node.val) {
					minValue = node.val;
					minIndex = i;
				}
			}
			if (minValue == Integer.MAX_VALUE) {
				continue;
			}
			lists.set(minIndex, lists.get(minIndex).next);
			iterator.next = new ListNode(minValue);
			minValue = Integer.MAX_VALUE;
			iterator = iterator.next;
		}
		return sentinel.next;
	}
    
}