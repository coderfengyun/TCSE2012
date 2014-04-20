class WeekOne{
public:
  bool isValidSudoku(vector<vector<char> > &board) {
		 bool used[9];

		 for (int i = 0; i < 9; i++){
			fill(used, used+9, false);
			for (int j = 0; j <9; j++){ 
				if (board[i][j] != '.'){
					if (!used[board[i][j] - '1'])
						used[board[i][j] - '1'] = true;
					else
						return false;
				}
			}

			fill(used, used+9, false);
			for (int j = 0; j< 9; j++){
				if (board[j][i] != '.'){
					if (!used[board[j][i] - '1'])
						used[board[j][i] - '1'] = true;
					else
						return false;
				}
			}
		}

		 //check each sub board
		for (int i = 0; i < 9; i+= 3){
			for (int j = 0; j< 9; j+= 3){
				if (! isValidOne(i, j, board))
					return false;
			}
		}
      return true;
    }

  bool isValidOne(int i, int j, vector<vector<char> > &board){
		 bool used[9];
		 fill(used, used+9, false);
		 for (int row = i; row < i+3; row ++){
			 for (int col = j; col < j+3; col ++){
				 if (board[row][col] != '.'){
					if (!used[board[row][col] - '1'])
						used[board[row][col] - '1'] = true;
					else
						return false;
				}
			 }
		 }
		 return true;
	 }
	


};
