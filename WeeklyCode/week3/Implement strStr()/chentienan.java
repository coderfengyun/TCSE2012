public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null ){
            return null;
        }
        if( haystack.isEmpty() && needle.isEmpty())
        {
            return "";
        }else if(needle.isEmpty()){
            return haystack;
        }
        int index = haystack.indexOf(needle);
        return index >= 0 ? haystack.substring(index) : null;
    }
}