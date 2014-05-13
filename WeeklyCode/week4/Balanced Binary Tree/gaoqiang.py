class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	def isBalanced(self, root):
		if root == None:
			return True
		else:
			result = self.postOrder(root)
		return True if result!=-1 else False

	def postOrder(self, root):
		if root == None:
			return 0
		leftDepth = self.postOrder(root.left)
		if leftDepth == -1:
			return -1
		rightDepth = self.postOrder(root.right)
		if rightDepth == -1:
			return -1
		if abs(leftDepth-rightDepth) > 1:
			return -1
		return (leftDepth if leftDepth>rightDepth else rightDepth) + 1

if __name__=='__main__':
	s = Solution()
	root = TreeNode(0)
	root.left = TreeNode(1)
	root.right = TreeNode(2)
	print s.isBalanced(root)