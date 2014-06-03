class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    result = []
    def subsetsWithDup(self, S):
    	S = sorted(S)
    	self.result = []
    	for i in range(0, len(S)):
    		self.dfs(S,i,[])
    	self.result.append([])
    	return self.result
    
    def dfs(self, s, start, pre_set):
    	if start==len(s):
    		return
    	current_set = [] + pre_set
    	current_set.append(s[start])
    	if current_set not in self.result:
    		self.result.append(current_set)
    	for i in range(start+1, len(s)):
    		self.dfs(s, i, current_set)

if __name__ == '__main__':
	s = Solution()
	print s.subsetsWithDup([1,2,2])