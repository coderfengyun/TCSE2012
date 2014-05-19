public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> sortedArray = new ArrayList<Integer>();
        for(ListNode headCopy = head; headCopy != null; headCopy = headCopy.next){
            sortedArray.add(headCopy.val);
        }
        return sortIt(sortedArray, 0, sortedArray.size() - 1);
    }
    
    private TreeNode sortIt(ArrayList<Integer> sortedArray, int begin, int end){
        if(begin > end){
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode result = new TreeNode(sortedArray.get(mid));
        result.left = sortIt(sortedArray, begin, mid - 1);
        result.right = sortIt(sortedArray, mid + 1, end);
        return result;
    }
}