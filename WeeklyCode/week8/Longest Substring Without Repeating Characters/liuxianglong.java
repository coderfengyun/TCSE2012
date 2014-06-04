class liuxianglong {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        boolean[] dup = new boolean[256];
        int max = 1;int begin =0;int cur =0;
        while(cur<s.length()){
            char c = s.charAt(cur++);
            while(dup[c]) dup[s.charAt(begin++)]=false;
            dup[c]=true;
            int len = cur-begin;
            if(max<len) max = len;
        }
        return max;
    }
}