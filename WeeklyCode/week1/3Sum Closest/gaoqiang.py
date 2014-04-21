class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
    	num.sort()
    	length=len(num)
    	if length<3:
    		return -1
    	minTarget=num[0]+num[1]+num[2]-target
    	for i in range(0,length-2):
    		j=i+1
    		k=length-1
    		while j<k:
    			tmp=num[i]+num[j]+num[k]-target
    			if tmp==0:
    				return target
    			if abs(tmp)<abs(minTarget):
    				minTarget=tmp
    			if tmp<0:
    				j=j+1
    			else:
    				k=k-1
    	return minTarget+target

if __name__=='__main__':
    s = Solution()
    print s.threeSumClosest([-1,2,1,-4],1)