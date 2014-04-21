int threeSumClosest(vector<int> &num, int target) {
        int l = num.size();
        int res=num[0]+num[1]+num[2];
        sort(num.begin(), num.end());
        for(int i=0; i<l-2; i++)
        {
            if(i && num[i]==num[i-1]) continue;
            int j=i+1,k=l-1;
            while(j<k)
            {
                if(j!=i+1 && num[j]==num[j-1]) {j++;continue;}
                if(k!=l-1 && num[k]==num[k+1]) {k--;continue;}
                int n = num[i]+num[j]+num[k];
                if(n == target)
                    return n;
                else if( n < target)
                    j++;
                else k--;
                if(abs(n-target) < abs(res-target))
                    res = n;
            }
        }
        return res;
    }
