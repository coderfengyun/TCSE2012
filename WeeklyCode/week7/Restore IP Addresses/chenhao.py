class Solution:
    
    def dfs(self,s,cur,arr,res):
        if cur>=len(s):
            if len(arr)==4:
                res.append('.'.join(arr))
            return
        if len(arr)==4:
            return
        if cur>=len(s):
            return
        for length in range(1,min(3,len(s)-cur)+1):
            sub=s[cur:cur+length]
            val=int(sub)
            if val<0 or val>255:
                continue
            if len(str(val))!=length:
                break;
            arr.append(sub)
            self.dfs(s,cur+length,arr,res)
            arr.pop()
    
    # @param s, a string
    # @return a list of strings
    def restoreIpAddresses(self, s):
        res=[]
        self.dfs(s,0,[],res)
        return res
        