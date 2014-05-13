bool isMatch(const char *s, const char *p)
{
    if( !s || !p) return !s&&!p;
    int lens= strlen(s), lenp=strlen(p);
    vector<vector<bool> > dp(lens+1, vector<bool>(lenp+1, false));
    dp[0][0]=true;
    for(int i=1; i<=lenp; i++)
        if(p[i-1] == '*')
            dp[0][i] = dp[0][i-2];
    for(int i=1; i<=lens; i++)
    {
        for(int j=1; j<=lenp; j++)
        {
            if (p[j-1]=='.' || s[i-1]==p[j-1])
				dp[i][j]=dp[i-1][j-1];
			else if ( p[j-1]=='*')
				dp[i][j]=dp[i][j-1]||dp[i][j-2]||(dp[i-1][j]&&(s[i-1]==p[j-2]||p[j-2]=='.'));
        }
    }
    return dp[lens][lenp];
}