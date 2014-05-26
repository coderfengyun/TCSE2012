class Solution:
    # @param x, a float
    # @param n, a integer
    # @return a float
    def pow(self, x, n):
    	if self.double_equal(x,0) and n<0:
    		return 0
    	if self.double_equal(x,0) or self.double_equal(x,1):
    		return x
    	if n==0:
    		return 1
    	if n==1:
    		return x
    	result = self.pow2(x,abs(n))
    	if n > 0:
    		return result
    	else:
    		return 1/result

    def double_equal(self,val1,val2):
    	return abs(val1-val2)<1E-7
    	
    def pow1(self, x, n):
    	result = 1.0
    	while n>0:
    		result = result*x
    		if abs(result)<1E-7:
    			return 0
    		n = n-1
    	

    def pow2(self, x, n):
    	if n==0:
    		return 1
    	if n==1:
    		return x
    	result = self.pow2(x, n/2)
    	result = result * result
    	if n%2!=0:
    		result = result*x
    	return result

if __name__ == '__main__':
	s = Solution()
	print s.pow(34.00515, -3)