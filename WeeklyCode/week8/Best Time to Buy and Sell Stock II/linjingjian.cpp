class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if(prices.size() == 0) return 0;
        prices.push_back(0);
        int first=0, ans=0, n=prices.size();
        for(int i=1; i<n; i++)
        {
            if(prices[i] < prices[first]){ first = i; continue;}
            if(i!=n && prices[i]<= prices[i+1]) continue;
            ans += prices[i] - prices[first];
            first = i+1;
        }
        return ans;
    }
};