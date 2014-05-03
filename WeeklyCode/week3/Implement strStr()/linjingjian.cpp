class Solution {
public:
    char *strStr(char *haystack, char *needle) {
		//sunday algorithm
        if(haystack==nullptr || needle==nullptr) return nullptr;
        int lenh=strlen(haystack), lenn=strlen(needle);
        if(lenh < lenn) return nullptr;
        vector<int> next(256, lenn+1);
        for(int i=0; i<lenn; i++)
            next[static_cast<unsigned char>(needle[i])] = lenn-i;
        int limit=lenh-lenn+1,j,k;
        for(int i=0; i<limit; i += next[haystack[i+lenn]])
        {
            k = i;
            for(j=0; j<lenn; j++)
            {
                if(haystack[k++] != needle[j])
                    break;
            }
            if(j == lenn)
                return haystack+i;
        }
        return nullptr;
    }
};