class liuxianglong {
	private void setDead(HashSet<Long> region, char[][] board){
    	int width=board[0].length;
        for(long num:region){
            int x = (int)(num/width);
            int y = (int)(num%width); 
            board[x][y]='X';
        }
    }
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0) return ;
        int height = board.length;
        int width = board[0].length;
        long total =(long) height*(long)width;
        HashSet<Long> visited = new HashSet<Long>();
        for(long i=0;i<total;i++){
            if(visited.contains(i)) continue;
            HashSet<Long> region = new HashSet<Long>();
            Queue<Long> queue = new LinkedList<Long>();
            queue.add(i);
            boolean living = false;
            while(queue.size()>0){
                long num = queue.poll();
                int x = (int)(num/width);
                int y = (int)(num%width);
                if(!visited.contains(num)){
                	if(board[x][y]=='O') {
                		region.add(num);
                		if(y>0)queue.offer(num-1);else living = true;
                		if(y<width-1)queue.offer(num+1);else living = true;
                		if(x>0)queue.offer(num-width);else living = true;
                		if(x<height-1)queue.offer(num+width);else living = true;
                	}
                    visited.add(num);
                }
            }
            if(!living) setDead(region,board);
        }
    }
}