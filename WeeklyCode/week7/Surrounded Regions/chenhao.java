public class Solution {
    
    private static final int[] dx={0,1,0,-1};
    private static final int[] dy={1,0,-1,0};

    int row,col;
    char[][] board;
    
    private boolean in(int r,int c){
        return r>=0 && r<row && c>=0 && c<col;
    }

    private void bfs(int sx,int sy){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(sx*col+sy);
        board[sx][sy]='@';
        while(!queue.isEmpty()){
            Integer peek=queue.poll();
            int cx=peek/col,cy=peek%col;
            for(int k=0;k<4;k++){
                int nx=cx+dx[k],ny=cy+dy[k];
                if(in(nx,ny) && board[nx][ny]=='O'){
                    board[nx][ny]='@';
                    queue.offer(nx*col+ny);
                }
            }
        }
    }
    
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0){
            return;
        }
        this.row=board.length;
        this.col=board[0].length;
        this.board=board;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(r==0 || c==0 || r==row-1 || c==col-1){
                    if(board[r][c]=='O'){
                        bfs(r,c);
                    }
                }
            }
        }
        
         for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(board[r][c]=='@'){
                    board[r][c]='O';
                }
                else if(board[r][c]=='O'){
                    board[r][c]='X';
                }
            }
         }
    }
}