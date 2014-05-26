# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
    	head = ListNode(-1)
    	cursor = head
    	topK = []
    	for i in range(0, len(lists)):
    		if lists[i]!=None:
    			topK.append(lists[i])
    	while len(topK)>0:
    		minIndex = self.getMinIndex(topK)
    		tmp = topK.pop(minIndex)
    		cursor.next = tmp
    		cursor = cursor.next
    		if tmp.next!=None:
    			tmp=tmp.next
    			topK.append(tmp)
    	return head.next

    def getMinIndex(self, lists):
    	index = 0
    	for i in range(0, len(lists)):
    		if lists[i].val < lists[index].val:
    			index = i
    	return index 


if __name__ == '__main__':
	s = Solution()
	a = ListNode(1)
	a.next = ListNode(3)
	b = ListNode(2)
	b.next = ListNode(4)
	node = s.mergeKLists([a,b])
	while node!=None:
		print node.val
		node=node.next