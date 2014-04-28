# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @param m, an integer
    # @param n, an integer
    # @return a ListNode
    def reverseBetween(self, head, m, n):
    	beforeStart = None
    	i=0
    	while i<m-1:
    		i = i+1
    		if beforeStart==None:
    			beforeStart = head
    		else:
    			beforeStart = beforeStart.next

    	i = i+1
    	if beforeStart==None:
    		p1 = head
    	else:
    		p1 = beforeStart.next
    	transientP1 = p1
    	p2 = p1.next
    	p1.next = None
    	p3 = None
    	while p2!=None and i<n:
    		p3 = p2.next
    		p2.next = p1
    		p1 = p2
    		p2 = p3
    		i=i+1
    	if beforeStart!=None:
    		beforeStart.next=p1
    		transientP1.next=p2
    		return head
    	else:
    		transientP1.next=p2
    		return p1 

if __name__=='__main__':
	s=Solution()
	head = None
	cursor = None;
	for i in range(1,6):
		if head==None:
			head = ListNode(i)
			cursor = head
		else:
			cursor.next = ListNode(i)
			cursor = cursor.next
	cursor = s.reverseBetween(head,1,5)
	while cursor!=None:
		print cursor.val
		cursor = cursor.next