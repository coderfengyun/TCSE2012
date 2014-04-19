public class Solution {
    public boolean search(int[] A, int target) {
        if(A.length == 0) return false;
        if(A.length == 1) return target == A[0];
        if(A[A.length - 1] > A[0]) return searchInSortedArray(A, target, 0, A.length - 1);
        else {
            return searchInRotatedArray(A, target);
        }
    }
    
    private boolean searchInSortedArray(int[] A, int target, int begin, int end)
    {
        int pivot = (end - begin) / 2 + begin;
        if(target == A[pivot]) 
        {
            return true;
        }
        else if(target > A[pivot])
        {
            if(pivot < end)
            {
                return searchInSortedArray(A, target, pivot + 1, end); 
            }
            else{
                return target == A[pivot];
            }
        }
        else{
            if(pivot > begin)
            {
                return searchInSortedArray(A, target, 0, pivot - 1);
            }
            else{
                return target == A[pivot];
            }
        }
    }
    
    private boolean searchInRotatedArray(int[] A, int target)
    {
        if(target == A[0]) return true;
        if(target == A[A.length - 1]) return true;
        if(target > A[0])
        {
            for(int i = 0; i < A.length - 1; i++)
            {
                if(A[i] == target) return true;
            }
        }
        else if(target < A[A.length - 1])
        {
            for(int i = A.length - 1; i > 0; i--)
            {
                if(A[i] == target) return true;
            }
        }
        return false;
    }
}