class Solution {
public:
    int totalNQueens(int n) {
        int *pos = new int[n];
        int ans = 0;
        dfs(0, n, pos, ans);
        delete [] pos;
        return ans;
    }
    
    void dfs(int step, int n, int pos[], int &ans)
    {
        if(step == n)
        {
            ++ans;
            return;
        }
        
        for(int i=0; i<n; i++)
        {
            pos[step] = i;
            bool flag = true;
            for(int j=0; j<step; j++)
            {
                if(i==pos[j] || abs(step-j) == abs(pos[j]-i))
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                dfs(step+1, n, pos, ans);
        }
    }
};