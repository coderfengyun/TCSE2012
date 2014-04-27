package org.bench4q.agent.test;

public class RemoveDuplicates {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode iterator = head;
		while (iterator != null) {
			while (iterator.next != null && iterator.next.val == iterator.val) {
				iterator.next = iterator.next.next;
			}
			iterator = iterator.next;
		}
		return iterator;
	}
}
