class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if(prices.size() == 0) return 0;
        int ans=0, first=0;
        for(int i=1; i<prices.size(); i++)
        {
            if(prices[i] < prices[first])
            {
                first = i;
                continue;
            }
            ans = max(prices[i]-prices[first], ans);
        }
        return ans;
    }
};