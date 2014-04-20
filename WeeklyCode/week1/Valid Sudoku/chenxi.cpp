class Solution {
public:
	bool isValidSudoku(vector<vector<char> > &board) {
		vector<char> v=board.at(0);
		int length=v.size();
		int dup[10];
		
		for(int j=0;j<board.size();j++){
			for(int i=('0'-'0');i<=('9'-'0');i++)
				dup[i]=0;
			//vector<char> v1=board[j];
			for(int i=0;i<length;i++){
				char c=board[j][i];
				if(c!='.'&&dup[c-'0']==0){
					dup[c-'0']++;
				}else if(c!='.'&&dup[c-'0']!=0){
				//	cout<<"!!!!!!!!!!!!!!!!";
					return false;
				}
			}
		}
		
		for(int i=0;i<length;i++){
			for(int i=('0'-'0');i<=('9'-'0');i++)
				dup[i]=0;
			for(int j=0;j<board.size();j++){
				//vector<char> v2=board[j];
				char c=board[j][i];
				if(c!='.'&&dup[c-'0']==0){
					dup[c-'0']++;
				}else if(c!='.'&&dup[c-'0']!=0){
					//cout<<"@@@@@@@@@@@@@@";
					return false;
				}
			}
		}
		
		for(int i=0;i<=board.size()-3;i+=3){
			for(int j=0;j<=length-3;j+=3){
				for(int i=('0'-'0');i<=('9'-'0');i++)
					dup[i]=0;
				for(int k=0;k<3;k++){
					for(int m=0;m<3;m++){
						//board[i+k][j+m]
						char c=board[i+k][j+m];
						if(c!='.'&&dup[c-'0']==0){
							dup[c-'0']++;
						}else if(c!='.'&&dup[c-'0']!=0){
						    //cout<<c;
						    //cout<<dup[c-'0'];
							//cout<<"3333333333333333333333333";
							return false;
						}
					}
				}
			}
		}
		return true;
	}
};
