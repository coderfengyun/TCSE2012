public class Solution {
    private int result = 0;
    public int totalNQueens(int n) {
        if(n < 4){
            return n == 1 ? 1 : 0;
        }
        int[] queenAddr = new int[n];
        placeQueen(0, n, queenAddr);
        return this.result;
    }
    
    private void placeQueen(int rowIndex, int n, int[] queenAddr){
        if(rowIndex == n){
            this.result ++;
            return;
        }
        for(int column = 0; column < n; column++){
            if(canBePlaced(rowIndex, column, n, queenAddr)){
                queenAddr[rowIndex] = rowIndex * n + column;
                placeQueen(rowIndex + 1, n, queenAddr);
            }
        }
    }
    
    private boolean canBePlaced(int rowIndex, int column, int n, int[] queenAddr){
        int num = rowIndex * n + column;
        for(int i = 0; i < rowIndex; i++){
            if((num % n) == (queenAddr[i] % n)){
                //Same column
                return false;
            }
            if((num - (rowIndex - i) * (n - 1)) == queenAddr[i]){
                //Forward slash
                return false;
            }
            if((num - (rowIndex - i) * (n + 1)) == queenAddr[i]){
                //Backward slash
                return false;
            }
        }
        return true;
    }
}