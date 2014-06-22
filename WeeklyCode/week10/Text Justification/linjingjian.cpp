class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
        vector<string> ans;
        int beg=0, len=0;
        if(words.size()==0 || L==0) return vector<string>(1,"");
        for(int i=0; i<words.size(); ++i)
        {
            if(len+words[i].size()+i-beg > L)
            {
                ans.push_back(join(words, beg, i-1, len, L));
                beg = i;
                len = 0;
            }
            len += words[i].size();
        }
        string last;
        if(beg == words.size()-1)
            last = words[beg]+string(L-len,' ');
        else
        {
            for(int i=beg; i<words.size(); i++)
            last += words[i]+' ';
            last += string(L-len-(words.size()-beg), ' ');
        }

        ans.push_back(last);
        return ans;
    }

    string join(vector<string> &words, int beg, int end, int len, int L)
    {
        string ans;
        int n = end-beg+1;
        if(n == 1) return words[beg]+string(L-len, ' ');
        int ave = (L-len)/(n-1);
        int limit = (L-len)%(n-1);
        for(int i=0; i<n; i++)
        {
            ans += words[beg+i];
            if(i < limit)
                ans += string(ave+1, ' ');
            else if( i < n-1)
                ans += string(ave, ' ');
        }
        return ans;
    }
};