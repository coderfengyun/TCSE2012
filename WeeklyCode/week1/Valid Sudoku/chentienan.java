public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9; row++)
        {
            for(int column = 0; column < 9; column++)
            {
                if(board[row][column] == '.') continue;
                if(!checkFor(row, column, board)) return false;                
            }
        }
        return true;
    }
    
    private boolean checkFor(int row, int column, char[][] board)
    {
        //check for row where the element stays
        for(int i = column + 1; i < 9; i++)
        {
            if(board[row][i] == board[row][column]) return false;
        }
        
        //check for column where the element stays
        for(int i = row + 1; i < 9; i++)
        {
            if(board[i][column] == board[row][column]) return false;
        }
        
        //check for 9 size cell where the element stays
        int cellRow = row / 3, cellColumn = column / 3;
        for(int i = row; i <= 2 + 3 * cellRow; i++)
        {
            for(int j = 3 * cellColumn; j <= 2 + 3 * cellColumn; j++)
            {
                if( j == column) continue;
                if(board[i][j] == board[row][column]) return false;
            }
        }
        return true;
    }
}