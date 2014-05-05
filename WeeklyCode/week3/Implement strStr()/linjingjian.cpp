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
	
	char *strStr2(char *haystack, char *needle)
    {
		//kmp
        int hlen = strlen(haystack);
        int nlen = strlen(needle);
        if(hlen < nlen) return NULL;
        int *shift = new int[nlen];
        shift[0]=-1;
        for(int i=1; i<nlen; i++)
        {
            int idx = shift[i-1];
            while(idx!=-1 && needle[i]!=needle[idx+1] )
                idx = shift[idx];
            if(needle[i] == needle[idx+1])
                shift[i] = idx+1;
            else shift[i] = -1;
        }
        int hidx=0,nidx=0;
        while(hidx<hlen && nidx<nlen)
        {
            if(haystack[hidx] == needle[nidx])
            {
                hidx++;nidx++;
            }
            else if(nidx==0) hidx++;
            else
            {
                nidx=shift[nidx-1]+1;
            }
        }
        delete []shift;
        if(nidx == nlen)
        {
            return haystack+hidx-nidx;
        }
        return NULL;
    }
};