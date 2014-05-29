class liuxianglong {
	private boolean valid(int[] position,int cur){
        for(int x=0;x<cur;x++){
            if(position[x]==position[cur]||Math.abs(position[cur]-position[x])==cur-x) return false;
        }
        return true;
    }
    private int dfs(int[] position , int x){
        if(position.length==x) return 1;
        int num=0;
        for(int y=0;y<position.length;y++){
            position[x]=y;
            if(valid(position,x)) num+=dfs(position,x+1);
        }
        return num;
    }
    public int totalNQueens(int n) {
        if(n<=0) return 0;
        int[] position = new int[n];
        return dfs(position,0);
    }
}