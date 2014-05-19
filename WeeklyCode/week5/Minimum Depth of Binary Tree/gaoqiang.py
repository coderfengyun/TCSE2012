# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def minDepth(self, root):
    	if root==None:
    		return 0
    	queue = []
    	queue.append(root)
    	height = 1
    	while len(queue)>0:
    		tmpList = []
    		while len(queue)>0:
    			tmpList.append(queue.pop(0))
    		for i in range(0,len(tmpList)):
    			tmpNode = tmpList[i]
    			if tmpNode.left == None and tmpNode.right==None:
    				return height
    			if tmpNode.left!=None:
    				queue.append(tmpNode.left)
    			if tmpNode.right!=None:
    				queue.append(tmpNode.right)
    		height = height+1

if __name__=='__main__':
	root = TreeNode(1)
	root.left = TreeNode(2)
	root.left = TreeNode(3)       
	s = Solution()
	print s.minDepth(root)