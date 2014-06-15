public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0){
            return new ArrayList<String>();
        }
        int n = s.length();
        return wordBreak0(s, dict, 0);
    }
    
    private List<String> wordBreak0(String s, Set<String> dict, int startIndex){
        List<String> result = new ArrayList<String>();
        List<Integer> ends = findAllInDict(dict, s, startIndex);
        for(Integer wordEnd : ends){
            String alreadyHave = s.substring(startIndex, wordEnd + 1);
            List<String> childs = wordBreak0(s, dict, wordEnd + 1);
            if(childs == null){
                continue;
            }
            for(String child : childs){
                result.add(alreadyHave + child);
            }
        }
        return result;
    }
    
    private List<Integer> findAllInDict(Set<String> dict, String s, int startIndex){
        List<Integer> result = new ArrayList<Integer>();
        int i = startIndex;
        while(i < s.length()){
            String posibleWord = s.substring(startIndex, i + 1);
            if(dict.contains(posibleWord)){
                result.add(i);
            }
            i++;
        }
        return result;
    }
}