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
		while (finishCount < totalCount) {
			TwoTupple tupple = getMin(lists, finish);
			finishCount += tupple.finishCount;
			if (tupple.minIndex == -1) {
				continue;
			}
			iterator.next = new ListNode(lists.get(tupple.minIndex).val);
			lists.set(tupple.minIndex, lists.get(tupple.minIndex).next);
			iterator = iterator.next;
		}
		return sentinel.next;
	}

	private TwoTupple getMin(ArrayList<ListNode> lists, boolean[] finish) {
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		int finishCount = 0;
		for (int i = 0; i < lists.size(); i++) {
			ListNode node = lists.get(i);
			if (node == null) {
				if (!finish[i]) {
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
		return new TwoTupple(minIndex, finishCount);
	}

	public class TwoTupple {
		public int minIndex;
		public int finishCount;

		public TwoTupple(int minIndex, int finishCount) {
			this.minIndex = minIndex;
			this.finishCount = finishCount;
		}
	}
    
}