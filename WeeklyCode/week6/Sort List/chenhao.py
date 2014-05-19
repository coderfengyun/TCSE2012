class Solution:

    def merge(self,head1,len1,head2,len2):
        vHead=ListNode(0)
        cur=vHead
        p=q=0
        while p<len1 or q<len2:
            if p<len1 and ( q>=len2 or head1.val<head2.val ):
                p+=1
                cur.next=head1
                head1=head1.next
            else:
                q+=1
                cur.next=head2
                head2=head2.next
            cur=cur.next
        cur.next=None
        return vHead.next

    def sort0(self, length):
        if length==1:
            head=self.cur
            self.cur=self.cur.next
            return head
        lHead=self.sort0(length//2)
        rHead=self.sort0(length-length//2)
        return self.merge(lHead,length//2,rHead,length-length//2)

    # @param head, a ListNode
    # @return a ListNode
    def sortList(self, head):
        if head==None:
            return None
        length=0
        cur=head
        while cur!=None:
            length+=1
            cur=cur.next
        self.cur=head
        return self.sort0(length)