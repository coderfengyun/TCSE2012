class Solution {
public:


vector<string> fullJustify(vector<string> &words, int L) {
    vector<string> results;
    if(words.empty() || L <= 0) return words;

    int curLen = 0;
    size_t i = 0;
    while(i < words.size())
    {
        curLen = words[i].size();

        size_t j = i + 1;
        for(; j < words.size(); j++){
            if(curLen + words[j].size() + 1 > L){
                break;
            }else{
                curLen += words[j].size() + 1;
            }
        }

        int wordsNum = j - i;
        int extraSpace = (j == words.size() ? 0 : L - curLen);

        int moreNum = 0;
        if(wordsNum > 1){moreNum = extraSpace % (wordsNum-1) ;}

        int avgSpace = extraSpace;
        if(wordsNum > 1){avgSpace = extraSpace/ (wordsNum-1) + 1;}

        string line(words[i]);
        if(wordsNum == 1){
            string spaces(avgSpace,' ');
            line.insert(line.end(),spaces.begin(),spaces.end());
        }

        for(size_t k = 1; k < wordsNum; k++){
            if(k <= moreNum){
                string spaces(avgSpace+1,' ');
                line.insert(line.end(),spaces.begin(),spaces.end());
            }else{
                string spaces(avgSpace,' ');
                line.insert(line.end(),spaces.begin(),spaces.end());
            }
            line.insert(line.end(),words[i+k].begin(),words[i+k].end());
        }

        if(line.size() < L){
            string spaces(L-line.size(),' ');
            line.insert(line.end(),spaces.begin(),spaces.end());
        }

        results.push_back(line);

        i = j;
    }

    return results;
}

};
