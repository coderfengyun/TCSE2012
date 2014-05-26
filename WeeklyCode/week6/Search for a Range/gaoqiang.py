class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
    	left = self.binarySearchLeft(A, 0, len(A)-1, target)
    	right = self.binarySearchRight(A, 0, len(A)-1, target)
    	return [left,right]

    def binarySearchLeft(self, A, start, end, target):
    	result = self.binarySearch(A, start, end, target)
    	while result!=0 and result!=-1 and A[result-1]==target:
    		result = self.binarySearchLeft(A, start, result-1, target)
    	return result

    def binarySearchRight(self, A, start, end, target):
    	result = self.binarySearch(A, start, end, target)
    	while result!=len(A)-1 and result!=-1 and A[result+1]==target:
    		result = self.binarySearchRight(A, result+1, end, target)
    	return result

    def binarySearch(self, A, start, end, target):
    	if start > end:
    		return -1
    	mid = (start+end)/2
    	if A[mid]==target:
    		return mid
    	if A[mid]<target:
    		return self.binarySearch(A, mid+1, end, target)
    	return self.binarySearch(A, start, mid-1, target)


if __name__ == '__main__':
	s = Solution()
	print s.searchRange([],11)