class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        height.push_back(0);
        stack<int> stk;
        int ans = 0, i=0;
        while(i != height.size())
        {
            if(stk.empty() || height[stk.top()] <= height[i])
                stk.push(i++);
            else
            {
                int idx = stk.top();
                stk.pop();
                int width = stk.empty()? i: i-stk.top()-1;
                ans = max(width*height[idx], ans);
            }
        }
        return ans;
    }
};