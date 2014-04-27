public class ReverseLinkedList {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m >= n)
			return head;
		ListNode iterator = head, mPrevious = null, mNode = null, mNext = null, iteratorforSwap = null, iteratorPrevious = null, iteratorNext = null;
		int index = -1;

		while (iterator != null && index < m - 1) {
			index++;
			iterator = iterator.next;
		}
		// Then it says iterator == null
		if (index != m - 1) {
			// Illegal input
			return head;
		}

		mPrevious = index != -1 ? iterator : null;
		mNode = iterator.next;
		mNext = iterator.next != null ? iterator.next.next : null;
		for (index = m + 1, iteratorforSwap = mNext, iteratorPrevious = mNode, iteratorNext = mNext.next; index <= n
				&& iteratorforSwap != null; index++, iteratorforSwap = iteratorforSwap.next) {
			// first delete it
			iteratorPrevious.next = iteratorNext;
			// insert between mPrevious and mNode
			mPrevious.next = iteratorforSwap;
			iteratorforSwap.next = mPrevious.next;
		}
		return head;
	}
}