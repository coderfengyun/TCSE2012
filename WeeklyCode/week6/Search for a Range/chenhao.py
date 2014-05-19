class Solution:
    
    def searchFirst(self, A, target):
        ans=-1
        lt=0
        rt=len(A)-1
        while lt<=rt:
            mid=(lt+rt)>>1
            if A[mid]>=target:
                if A[mid]==target:
                    ans=mid
                rt=mid-1
            else:
                lt=mid+1
        return ans
    
    def searchLast(self, A, target):
        ans=-1
        lt=0
        rt=len(A)-1
        while lt<=rt:
            mid=(lt+rt)>>1
            if A[mid]<=target:
                if A[mid]==target:
                    ans=mid
                lt=mid+1
            else:
                rt=mid-1
        return ans
    
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
        return [self.searchFirst(A,target),self.searchLast(A,target)]
        