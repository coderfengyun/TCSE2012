#Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
    	# process special inputs
    	if l1==None and l2==None:
    		return None
    	elif l1==None:
    		return l2
    	elif l2==None:
    		return l1

    	# head and cursor are usually necessary
    	head = None
    	cursor = None
    	carry = 0
    	while l1!=None and l2!=None:
    		sum = l1.val + l2.val + carry
    		carry = sum/10
    		sum = sum%10
    		current = ListNode(sum)
    		if head==None:
    			head = current
    			cursor = current
    		else:
    			cursor.next = current
    			cursor = cursor.next
    		l1 = l1.next
    		l2 = l2.next

    	left = None
    	if l1!=None or l2!=None:
    		left = l1 if l1!=None else l2
    	while left!=None:
    		sum = left.val + carry
    		carry = sum/10
    		sum = sum%10
    		current = ListNode(sum)
    		cursor.next = current
    		cursor = cursor.next
    		left = left.next
    	if carry==1:
    		cursor.next = ListNode(1)
    	return head

if __name__=='__main__':
	s=Solution()
	l1 = ListNode(2)
	l1.next = ListNode(4)
	l1.next.next = ListNode(3)
	l2 = ListNode(5)
	l2.next = ListNode(6)
	l2.next.next = ListNode(4)
	l3 = s.addTwoNumbers(l1,l2)
	while l3!=None:
		print l3.val
		l3=l3.next