public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9; row++)
        {
            for(int column = 0; column < 9; column++)
            {
                if(checkFor(row, column, board)) return false;                
            }
        }
        return true;
    }
    
    private boolean checkFor(int row, int column, char[][] board)
    {
        if(column < 9)
        {
            //check for row where the element stays
            for(int i = column + 1; i < 9; i++)
            {
                if(char[row][i] == char[row][column]) return false;
            }
            
            //check for column where the element stays
            for(int i = row + 1; i < 9; i++)
            {
                if(char[i][column] == char[row][column]) return false;
            }
            
            //check for 9 size cell where the element stays
            int cellRow = row / 3, cellColumn = column / 3;
            for(int i = row + 1; i < 2 + 3 * cellRow; i++)
            {
                for(int j = column + 1; j < 2 + 3 * cellColumn; j++)
                {
                    if(char[i][j] == char[row][column]) retur false;
                }
            }
        }
        return true;
    }
}