class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
        curHead=TreeLinkNode(0)
        curHead.next=root
        while curHead.next!=None:
            nextHead=TreeLinkNode(0)
            pCur=curHead.next
            pNext=nextHead
            while pCur!=None:
                for node in (pCur.left,pCur.right):
                    if node!=None:
                        pNext.next=node
                        pNext=pNext.next
                pCur=pCur.next
            curHead=nextHead