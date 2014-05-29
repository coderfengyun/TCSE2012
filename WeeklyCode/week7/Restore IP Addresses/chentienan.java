public class Solution {
    private static final int Upper_Bound = 256;
    private List<String> result = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12){
            return this.result;
        }
        dfs(0, 0, s, "");   
        return this.result;
    }
    
    private void dfs(int currentIndex, int currentSection, String origin, String currentResult){
        if(currentSection == 4 && currentIndex >= origin.length()){
            this.result.add(currentResult);
            return;
        }
        for(int i = currentIndex + 1; i <= currentIndex + 3 && i <= origin.length(); i++){
            String section = origin.substring(currentIndex, i);
            if(Integer.parseInt(section) >= Upper_Bound){
                continue;
            }
            if(section.length() > 1 && section.charAt(0) == '0'){
                break;
            }
            dfs(i, currentSection + 1, origin, currentResult.isEmpty()? section : currentResult + "." + section);
        }
    }
}