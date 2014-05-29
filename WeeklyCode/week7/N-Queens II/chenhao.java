public class Solution {
    
    int n;
    boolean[] column,diagonal,antiDiagonal;
    int ans;
    
    boolean checkAndSet(int r,int c){
        if(!column[c] && !diagonal[r+c] && !antiDiagonal[r-c+n]){
            column[c]=diagonal[r+c]=antiDiagonal[r-c+n]=true;
            return true;
        }
        else{
            return false;
        }
    }
    
    void reset(int r,int c){
        column[c]=diagonal[r+c]=antiDiagonal[r-c+n]=false;
    }
    
    private void dfs(int r){
        if(r==n){
            ans+=1;
            return;
        }
        for(int c=0;c<n;c++){
            if(checkAndSet(r,c)){
                dfs(r+1);
                reset(r,c);
            }
        }
    }
    
    public int totalNQueens(int n) {
        this.ans=0;
        this.n=n;
        this.column=new boolean[n];
        this.diagonal=new boolean[2*n];
        this.antiDiagonal=new boolean[2*n];
        dfs(0);
        return ans;
    }
}


public class Solution2 {
    
    int ans,limit;
    
    public int totalNQueens(int n) {
        ans=0;
        limit=(1<<n)-1;
        dfs(0,0,0);
        return ans;
    }
    
    /* backtrace program using bit-wise operation to speed up calculation.
     * 'limit' is all '1's.
     * 'h'  is the bits all the queens vertically projected on a row. If h==limit, then it's done, answer++.
     * 'r'   is the bits all the queens anti-diagonally projected on a row.
     * 'l'   is the bits all the queens diagonally projected on a row.
     * h|r|l  is all the occupied bits. Then pos = limit & (~(h|r|l)) is all the free positions.
     * p = pos & (-pos)  gives the right most '1'. pos -= p means we will place a queen on this bit 
     *                             represented by p.
     * 'h+p'  means one more queue vertically projected on next row.
     * '(r+p)<<1'  means one more queue anti-diagonally projected on next row. Because we are
     *                   moving to next row and the projection is skew from right to left, we have to 
     *                   shift left one position after moved to next row.
     * '(l+p)>>1'  means one more queue diagonally projected on next row. Because we are 
     *                  moving to next row and the projection is skew from left to right, we have to 
     *                  shift right one position after moved to next row.
     */
    void dfs(int h,int l,int r){
        if(h==limit){
            ans++;
            return;
        }
        int pos=limit & (~(h|l|r));
        while(pos!=0){
            int p=pos&(-pos);
            pos-=p;
            dfs(h+p,(l+p)>>1,(r+p)<<1);
        }
    }
    
}