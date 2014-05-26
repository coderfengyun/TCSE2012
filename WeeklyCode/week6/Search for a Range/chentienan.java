public class Solution {
    public int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		result[0] = findLowerBound(A, target, 0, A.length - 1);
		if(result[0] == -1){
		    result[1] = -1;
		    return result;
		}else{
		    result[1] = findUpperBound(A, target, 0, A.length - 1);
		    return result;    
		}
		
	}

	private int findLowerBound(int[] A, int target, int begin, int end) {
		if (end < begin) {
			return -1;
		}
		int mid = (begin + end) / 2;
		if (A[mid] > target) {
			return findLowerBound(A, target, begin, mid - 1);
		} else if (A[mid] == target) {
			int leftResult = findLowerBound(A, target, begin, mid - 1);
			return leftResult == -1 ? mid : leftResult;
		} else {
			return findLowerBound(A, target, mid + 1, end);
		}
	}

	private int findUpperBound(int[] A, int target, int begin, int end) {
		if (end < begin) {
			return -1;
		}
		int mid = (begin + end) / 2;
		if (A[mid] < target) {
			return findUpperBound(A, target, mid + 1, end);
		} else if (A[mid] == target) {
			int leftResult = findUpperBound(A, target, mid + 1, end);
			return leftResult == -1 ? mid : leftResult;
		} else {
			return findUpperBound(A, target, begin, mid - 1);
		}
	}
}