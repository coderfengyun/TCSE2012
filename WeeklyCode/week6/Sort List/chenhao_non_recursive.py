import time

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __repr__(self):
        return str(self.val)

def makeList(valList):
    head=cur=ListNode(valList[0])
    for val in valList[1:]:
        cur.next=ListNode(val)
        cur=cur.next
    return head

def printList(head):
    while head!=None:
        print(head.val, end=' ')
        head=head.next
    print()
    
class Solution:

    def getFirstK(self,head,k):
        vHead=ListNode(0)
        cur=vHead
        for i in range(0,k):
            if head==None:
                break
            cur.next=head
            cur=cur.next
            head=head.next
        cur.next=None
        return (vHead.next,head)

    def merge(self,list1,list2):
        vHead=ListNode(0)
        cur=vHead
        while list1!=None and list2!=None:
            if  list1.val<list2.val:
                cur.next=list1
                list1=list1.next
            else:
                cur.next=list2
                list2=list2.next
            cur=cur.next
        cur.next=list1 if list1!=None else list2
        while cur.next!=None:
            cur=cur.next
        return (vHead.next,cur)

    def sort0(self,head,step):
        vHead=ListNode(0)
        rear=vHead

        cur=head
        k=0
        while True:
            (list1,cur)=self.getFirstK(cur,step)
            if list1==None:
                break
            (list2,cur)=self.getFirstK(cur,step)
            (rear.next,mergedRear)=self.merge(list1,list2)
            rear=mergedRear
            k+=1
        return (vHead.next,k==1)

    # @param head, a ListNode
    # @return a ListNode
    def sortList(self, head):
        if head==None:
            return None
        
        step=1
        end=False
        while not end:
            (head,end)=self.sort0(head,step)
            step*=2
        return head

        
if __name__ == '__main__':
    head=makeList([1]*100000)
    # head=makeList([3,2,1,1])
    # printList(head)
    start=time.time()
    newHead=Solution().sortList(head)
    print(time.time()-start)
    # printList(newHead)