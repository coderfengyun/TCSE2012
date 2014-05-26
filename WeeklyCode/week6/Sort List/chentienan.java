/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
		int length = getLength(head);
		if (length <= 1) {
			return head;
		}
		return mergeSort(head, length - 1);
	}

	private ListNode mergeSort(ListNode beginNode, int distance) {
		if (beginNode == null) {
			return null;
		}
		ListNode vHead = new ListNode(beginNode.val);
		if (distance == 0) {
			return vHead;
		}
		ListNode left = mergeSort(beginNode, distance / 2);
		ListNode right = mergeSort(getNodeWithIn(distance / 2 + 1, beginNode),
				distance - distance / 2);
		return merge(left, right);
	}

	private ListNode merge(ListNode node, ListNode mergePartner) {
		ListNode vHead = new ListNode(-1), current = vHead, notNull = null;
		while (node != null && mergePartner != null) {
			if (node.val <= mergePartner.val) {
				current.next = new ListNode(node.val);
				node = node.next;
			} else {
				current.next = new ListNode(mergePartner.val);
				mergePartner = mergePartner.next;
			}
			current = current.next;
		}
		notNull = node == null ? mergePartner : node;
		while (notNull != null) {
			current.next = new ListNode(notNull.val);
			notNull = notNull.next;
		}
		return vHead.next;
	}

	private ListNode getNodeWithIn(int step, ListNode node) {
		int walkedSteps = 0;
		ListNode iterator = node;
		while (walkedSteps < step && iterator != null) {
			iterator = iterator.next;
			walkedSteps++;
		}
		return iterator;
	}

	private int getLength(ListNode head) {
		ListNode iterator = head;
		int result = 0;
		while (iterator != null) {
			result++;
			iterator = iterator.next;
		}
		return result;
	}
}