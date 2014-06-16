class liuxianglong {
	private void dfs(ArrayList<String> res, String s,boolean[][] record, int cur,String raw){
        if(cur==0){
            res.add(s.substring(0,s.length()-1));
        }else{
            for(int i=0;i<cur;i++){
                if(record[cur][i]){
                    String next = raw.substring(i,cur)+" "+s;
                    dfs(res,next,record,i,raw);
                }
            }
        }
    }
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        if(s.length()==0) return res;
        boolean[] dp = new boolean[s.length()+1];dp[0]=true;
        boolean[][] record = new boolean[s.length()+1][s.length()+1];
        for(int i =0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                boolean tmp =dp[j]&&dict.contains(s.substring(j,i+1));
                if(!tmp) continue;
                dp[i+1]=true;
                record[i+1][j]=true;
            }
        }
        dfs(res,"",record,s.length(),s);
        return res;
    }
}