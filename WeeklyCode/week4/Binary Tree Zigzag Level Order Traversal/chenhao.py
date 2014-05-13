class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def zigzagLevelOrder(self, root):
        res=[]
        if root==None:
            return res
        curLayer=[root]
        forward=True
        while len(curLayer)>0:
            n=len(curLayer)
            order=range(0,n) if forward else range(n-1,-1,-1)
            res.append([ curLayer[i].val for i in order ])
            curLayer=[ item for pair in ( (node.left,node.right) for node in curLayer ) for item in pair if item!=None ]
            forward=not forward
        return res