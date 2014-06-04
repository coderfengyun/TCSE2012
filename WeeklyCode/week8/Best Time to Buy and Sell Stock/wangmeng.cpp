class Solution {
public:
  int maxProfit(vector<int> &prices) {
    if (prices.size() < 2) return 0;
    int minv = prices[0], maxv = 0;
    for_each(prices.begin()+1, prices.end(), [&](int p) {
	maxv = max(maxv, p-minv);
	minv = min(minv, p);
      });
    return maxv;
  }
};
