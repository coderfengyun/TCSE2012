
class Solution:
    
    cache={}
    
    def cloneTree(self,root):
        if root==None:
            return None
        clone=TreeNode(root.val)
        clone.left=self.cloneTree(root.left)
        clone.right=self.cloneTree(root.right)
        return clone
    
    def generateTreesStructure(self,n):
        if n==0:
            return [None]
        if n==1:
            return [TreeNode(0)]
        if self.cache.get(n)!=None:
            return self.cache.get(n)
        res=[]
        for nLeft in range(0,n):
            nRight=n-1-nLeft
            for left in self.generateTreesStructure(nLeft):
                for right in self.generateTreesStructure(nRight):
                    root=TreeNode(0)
                    root.left=self.cloneTree(left)
                    root.right=self.cloneTree(right)
                    res.append(root)
        self.cache[n]=res
        return res
    
    def assignValues(self,cur):
        if cur==None:
            return
        self.assignValues(cur.left)
        cur.val=self.curVal
        self.curVal+=1
        self.assignValues(cur.right)
    
    # @return a list of tree node
    def generateTrees(self, n):
        trees=self.generateTreesStructure(n)
        for root in trees:
            self.curVal=1
            self.assignValues(root)
        return trees