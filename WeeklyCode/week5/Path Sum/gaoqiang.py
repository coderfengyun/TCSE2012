# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a boolean
    targetValue = 0
    def hasPathSum(self, root, sum):
    	self.targetValue = sum
    	return self.dfs(root,0)

    def dfs(self, root, sum):
    	if root==None:
    		return False
    	sum = sum+root.val
    	if sum==self.targetValue and root.left==None and root.right==None:
    		return True
    	result = self.dfs(root.left, sum)
    	if result:
    		return result
    	result = self.dfs(root.right, sum)
    	return result
        