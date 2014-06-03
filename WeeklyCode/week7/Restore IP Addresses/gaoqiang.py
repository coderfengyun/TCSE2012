class Solution:
    # @param s, a string
    # @return a list of strings
    result = []
    end = []

    def restoreIpAddresses(self, s):
    	if s == None or len(s) < 4 or len(s) > 12:
    		return []
    	self.result = []
    	self.end = [0,0,0,0]
    	self.dfs(s, 0, 0)
    	return self.result

    def dfs(self, s, section, start):
    	if section==4:
    		if start==len(s):
    			ip = ''
    			begin = 0
    			for i in range(0,4):
    				ip = ip + ('' if i==0 else '.') + s[begin:self.end[i]+1]
    				begin = self.end[i]+1
    			self.result.append(ip)
    		return False
    	for i in range(start, len(s)):
    		if self.check(s, start, i):
    			self.end[section] = i
    			self.dfs(s, section+1, i+1)

    def check(self, s, start, end):
    	if end >= len(s):
    		return False
    	if end-start>=1 and s[start]=='0':
    		return False
    	number = int(s[start:end+1])
    	if number>255:
    		return False
    	return True

if __name__=='__main__':
	s = Solution()
	print s.restoreIpAddresses('010010')