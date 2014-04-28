# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        if head==None or head.next==None:
            return head
        cursor = ListNode(0)
        newHead = None
        tail = None
        cursor.next = head
        while cursor.next!=None:
            if cursor.next.next!=None and cursor.next.val == cursor.next.next.val:
                toBeDelVal = cursor.next.val
                while cursor.next!=None and cursor.next.val==toBeDelVal:
                    cursor=cursor.next
            else:
                if newHead==None:
                    newHead=cursor.next
                    tail=newHead
                else:
                    tail.next=cursor.next
                    tail=tail.next
                cursor = cursor.next
        if tail!=None:
            tail.next = None
        return newHead
if __name__=='__main__':
    s = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(2)
    tmp = s.deleteDuplicates(head)
    while tmp!=None:
        print tmp.val
        tmp = tmp.next
    