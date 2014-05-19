public class Solution {
    
    private ListNode findMin(List<ListNode> listOfHeads){
        ListNode minNode=null;
        int minIndex=-1;
        for(int i=0;i<listOfHeads.size();i++){
            ListNode node=listOfHeads.get(i);
            if(node!=null){
                if(minNode==null || node.val<minNode.val){
                    minNode=node;
                    minIndex=i;
                }
            }
        }
        if(minIndex>=0){
            listOfHeads.set(minIndex,minNode.next);
        }
        return minNode;
    }
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        List<ListNode> listOfHeads=new ArrayList<>(lists);
        ListNode vHead=new ListNode(0);
        ListNode cur=vHead,next=null;
        while((next=findMin(listOfHeads))!=null){
            cur.next=next;
            cur=next;
        }
        return vHead.next;
    }
}