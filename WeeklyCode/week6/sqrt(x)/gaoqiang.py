class Solution:
    # @param x, an integer
    # @return an integer
    def sqrt(self, x):
    	return self.binarySearch(0,x/2+1,x)

    def binarySearch(self, start, end, target):
    	if start>end:
    		return None
    	mid = (start+end)/2
    	value = mid*mid
    	if value==target:
    		return mid
    	if value<target:
    		if (mid+1)*(mid+1)>target:
    			return mid
    		return self.binarySearch(mid+1, end, target)
    	return self.binarySearch(start, mid-1, target)

if __name__ == '__main__':
	s = Solution()
	print s.sqrt(2)