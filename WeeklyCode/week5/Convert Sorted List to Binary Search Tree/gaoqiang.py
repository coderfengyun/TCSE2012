class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
	# @param head, a list node
    # @return a tree node
    def sortedListToBST(self, head):
    	cursor = head
    	num = []
    	while cursor!=None:
    		num.append(cursor.val)
    		cursor = cursor.next
    	return self.sortedArrayToBST(num)

    # @param num, a list of integers
    # @return a tree node
    def sortedArrayToBST(self, num):
    	return self.convert(num,0,len(num)-1)
    	
    def convert(self, num, start, end):
    	if start > end:
    		return None
    	mid = (start + end)/2
    	node = TreeNode(num[mid])
    	node.left = self.convert(num, start, mid-1)
    	node.right = self.convert(num, mid+1, end)
    	return node

    def printTree(self, root):
		if root==None:
			return
		print str(root.val) + "->"
		self.printTree(root.left)
		self.printTree(root.right)

if __name__=='__main__':
	s = Solution()
	root = TreeNode(1)
	cursor = root
	for i in range(2,7):
		cursor.next = ListNode(i)
		cursor = cursor.next
	node = s.sortedListToBST(root)
	s.printTree(node)       