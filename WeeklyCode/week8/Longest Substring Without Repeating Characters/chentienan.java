public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0, lastOccur = -1;
        if(s == null || s.isEmpty()){
            return result;
        }
        List<Character> container = new ArrayList<Character>(), temp = new ArrayList<Character>();
        for(char ch : s.toCharArray()){
            if((lastOccur = container.indexOf(ch)) != -1){
                result = Math.max(result, container.size());
                temp = new ArrayList<Character>();
                temp.addAll(container.subList(lastOccur + 1, container.size()));
                container = temp;
            }
            container.add(ch);
        }
        return Math.max(result, container.size());
    }
}