class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
        vHead=ListNode(0)
        cur=vHead
        
        heap=[ (listHead.val,listHead) for listHead in lists if listHead!=None ]  
        heapq.heapify(heap) 
        
        while len(heap)!=0:
            val,node=heapq.heappop(heap)
            cur.next=node
            cur=node
            if node.next!=None:
                heapq.heappush(heap,(node.next.val,node.next))
        cur.next=None
        
        return vHead.next