public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int ans=0;
        for(int i=0,j=0;i<s.length();i++){
            Character c=s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(j++));
            }
            set.add(c);
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}