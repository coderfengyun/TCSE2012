class Solution {
public:
    string multiply(string num1, string num2) {
        int len1 = num1.size(), len2 = num2.size();
        int *n1 = new int[len1];
        int *n2 = new int[len2];
        for(int i=len1-1,j=0; i>=0; --i,++j)
            n1[j] = num1[i]-'0';
        for(int i=len2-1,j=0; i>=0; --i,++j)
            n2[j] = num2[i]-'0';
        int *n = new int[len1+len2];
        memset(n, 0, sizeof(int)*(len1+len2));
        for(int i=0; i<len1; i++)
        {
            for(int j=0; j<len2; j++)
            {
                n[i+j] += n1[i]*n2[j];
            }
        }
        string ans;
        for(int i=0; i<len1+len2-1; i++)
        {
            if(n[i] >= 10)
                n[i+1] += n[i]/10;
            n[i] = n[i]%10;
        }
        int i=len1+len2-1;
        while( n[i] == 0 && i>=0) i--;
        if(i < 0 ) return string("0");
        while(i >= 0 )
        {
            ans += '0'+n[i];
            i--;
        }
        return ans;
        delete []n1;
        delete []n2;
        delete []n;
        return ans;
    }
};