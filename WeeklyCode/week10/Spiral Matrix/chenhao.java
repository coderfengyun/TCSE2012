public class Solution {

    private static final int[] dx={0,1,0,-1};
    private static final int[] dy={1,0,-1,0};
    
    int n,m;
    boolean[][] visited;
    
    boolean inBoundAndUnvisited(int r,int c){
        return r>=0 && r<n && c>=0 && c<m && !visited[r][c];
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<Integer>();
        if((n=matrix.length)==0 || (m=matrix[0].length)==0){
            return res;
        }
        this.visited=new boolean[n][m];
        int x=0,y=0;
        int d=0;
        for(int k=0;k<n*m;k++){
            res.add(matrix[x][y]);
            visited[x][y]=true;
            int nx=x+dx[d],ny=y+dy[d];
            if(!inBoundAndUnvisited(nx,ny)){
                d=(d+1)%4;
                nx=x+dx[d];
                ny=y+dy[d];
            }
            x=nx;
            y=ny;
        }
        return res;
    }
}

public class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<Integer>();
        int n,m;
        if((n=matrix.length)==0 || (m=matrix[0].length)==0){
            return res;
        }
        int nCircles=Math.min((n+1)/2,(m+1)/2);
        for(int k=0,lenX=n,lenY=m;k<nCircles;k++){
            int x=k,y=k;
            for(int i=0;i<lenY;i++){
                res.add(matrix[x][y+i]);
            }
            for(int i=0;i<lenX-2;i++){
                res.add(matrix[x+i+1][y+lenY-1]);
            }
            if(lenX>1){
                for(int i=0;i<lenY;i++){
                    res.add(matrix[x+lenX-1][y+lenY-1-i]);
                }
            }
            if(lenY>1){
                for(int i=0;i<lenX-2;i++){
                    res.add(matrix[x+lenX-2-i][y]);
                }
            }
            lenX-=2;
            lenY-=2;
        }
        return res;
    }
}