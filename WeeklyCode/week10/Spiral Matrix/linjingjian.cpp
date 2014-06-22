class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        vector<int> ans;
        int m = matrix.size();
        if(m == 0) return ans;
        int n = matrix[0].size();
        if(n==0) return ans;
        int begx=0, endx=m-1, begy=0, endy=n-1;
        while(endx>=begx && endy>=begy)
        {
            for(int i=begy; i<=endy; i++)
                ans.push_back(matrix[begx][i]);
            for(int i=begx+1; i<=endx; i++)
                ans.push_back(matrix[i][endy]);
            if(endx > begx)
                for(int i=endy-1; i>=begy; i--)
                    ans.push_back(matrix[endx][i]);
            if(begy < endy)
                for(int i=endx-1; i>begx; i--)
                    ans.push_back(matrix[i][begy]);
            ++begx;
            --endx;
            ++begy;
            --endy;
        }
        return ans;
    }
};