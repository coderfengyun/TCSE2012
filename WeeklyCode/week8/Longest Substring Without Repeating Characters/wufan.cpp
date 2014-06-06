class Solution {
public:
    int lengthOfLongestSubstring(string s) {
       if (s.length() == 0) return 0;
       map<char, int> exsited;
       int cur_len = 0, max_len = 0;
       int start = 0;
       for (int i = 0; i < s.length(); i++){
           char c = s[i];
           if (exsited.find(c) == exsited.end()){
                cur_len++;
           }else{
               if (exsited[c] < start){
                   cur_len++;
               }else{
                   cur_len = i - exsited[c];
                   start = exsited[c]+1;
               }
           }
           exsited[c] = i;
           if (cur_len > max_len) 
                max_len = cur_len;
       }
       return max_len;
    }

};
