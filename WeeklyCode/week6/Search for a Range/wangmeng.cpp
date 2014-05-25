class Solution {
public:
    // Return a pair [m,n] satisfing A[m] < target && A[n] >= target && n=m+1
    pair<int, int> searchPair(int A[], int n, int target) {
        int lt = 0, rht = n-1;
        // Loop invariant: A[lt] < target && A[rht] >= target
        // Progress operation: Half [lt, rht] each iteration
        // Boundary: rht-lt == 1
        while(rht-lt>1) { 
            int mid=(rht+lt) >> 1;
            if (A[mid] >= target) rht = mid;
            else lt = mid;
        }
        return make_pair(lt, rht);
    }
    
    vector<int> searchRange(int A[], int n, int target) {
        vector<int> result(2, -1);
        if (n == 0 || target < A[0] || target > A[n-1]) return result;
        result[0] = A[0] == target? 0:searchPair(A, n, target).second;
        result[1] = A[n-1] == target? n-1:searchPair(A, n, target+1).first;
        return A[result[0]] == target? result:vector<int>(2, -1);
    }
};
