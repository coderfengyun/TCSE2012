class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
	cursor = None
	def buildTree(self, preorder, inorder):
		if preorder==None or inorder==None or len(preorder)==0 or len(inorder)==0:
			return None
		self.cursor = 0
		return self.buildTree2(preorder, inorder, 0, len(inorder)-1)
	def buildTree2(self, preorder, inorder, instart, inend):
		if self.cursor>=len(preorder) or instart>inend:
			return None
		value = preorder[self.cursor]
		self.cursor = self.cursor+1
		head = TreeNode(value)
		pivot = None
		for i in range(instart, inend+1):
			if inorder[i]==value:
				pivot=i
				break
		head.left = self.buildTree2(preorder, inorder, instart, pivot-1)
		head.right = self.buildTree2(preorder, inorder, pivot+1 , inend)
		return head

	def printTree(self, root):
		if root==None:
			return
		print str(root.val) + "->"
		self.printTree(root.left)
		self.printTree(root.right)

if __name__=='__main__':
	s = Solution()
	node = s.buildTree([1,2,4,6,3,5],[4,6,2,1,5,3])
	s.printTree(node)
