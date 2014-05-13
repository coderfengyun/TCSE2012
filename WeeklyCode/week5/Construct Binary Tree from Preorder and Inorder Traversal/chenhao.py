# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param preorder, a list of integers
    # @param inorder, a list of integers
    # @return a tree node
    def buildTree(self, preorder, inorder):
        return self.build(preorder,inorder,0,0,len(preorder))
        
    def build(self,preorder,inorder,preOffset,inOffset,length):
        if length<=0:
            return None
        if length==1:
            return TreeNode(preorder[preOffset])
        
        rootValue=preorder[preOffset]
        inIndex=inorder.index(rootValue,inOffset,inOffset+length)
        leftLength=inIndex-inOffset
        left=self.build(preorder,inorder,preOffset+1,inOffset,leftLength)
        right=self.build(preorder,inorder,preOffset+1+leftLength,inIndex+1,length-1-leftLength)
        
        root=TreeNode(rootValue)
        root.left=left
        root.right=right
        
        return root