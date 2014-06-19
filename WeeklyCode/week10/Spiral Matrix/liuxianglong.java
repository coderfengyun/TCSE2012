class liuxianglong {
	public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m==0) return res;
        int n = matrix[0].length;
        int direction = 0;
        int[] dx = {0,1,0,-1};int x = 0;
        int[] dy = {1,0,-1,0};int y = -1;
        int step = n;
        while(step>0){
            for(int i =0;i<step;i++){
                x+=dx[direction];
                y+=dy[direction];
                res.add(matrix[x][y]);
            }
            direction=(direction+1)%4;
            if(direction%2==1){
                m--;
                n--;
                step=m;
            }else{
                step = n;
            }
        }
        return res;
    }
}