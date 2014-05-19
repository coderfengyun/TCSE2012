# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @return a list of tree node
    def generateTrees(self, n):
    	return self.generateTrees2(1,n)

    def generateTrees2(self, start, end):
    	trees = []
    	if start>end:
    		trees.append(None)
    	for i in range(start, end+1):
    		leftChildren = self.generateTrees2(start, i-1)
    		rightChildren = self.generateTrees2(i+1, end)
    		for m in range(0, len(leftChildren)):
    			for n in range(0, len(rightChildren)):
    				current = TreeNode(i)
    				current.left = leftChildren[m]
    				current.right = rightChildren[n]
    				trees.append(current)
    	return trees

        