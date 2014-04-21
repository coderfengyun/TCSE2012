public class Solution {
    private int target;

	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}
		this.target = target;
		return binarySearch(A, 0, A.length - 1);
	}

	private boolean binarySearch(int[] A, int start, int end) {
		if (start > end)
			return false;
		int mid = (start + end) / 2;
		if (A[mid] == target) {
			return true;
		}
		if (A[start] == A[mid] && A[start] == A[end]) {
			for (int i = start; i < mid; i++) {
				if (A[i] != A[start]) {
					return binarySearch(A, start, mid - 1);
				}
			}
			return binarySearch(A, mid + 1, end);
		}
		if (A[start] <= A[mid]) {
			if (A[start] <= target && A[mid] > target) {
				return binarySearch(A, start, mid - 1);
			} else {
				return binarySearch(A, mid + 1, end);
			}
		} else {
			if (A[mid] < target && A[end] >= target) {
				return binarySearch(A, mid + 1, end);
			} else {
				return binarySearch(A, start, mid - 1);
			}
		}
	}

}