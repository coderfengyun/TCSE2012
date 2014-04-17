#include<iostream>
#include<algorithm>
#include<vector>
#include<cstdlib>
#include<cstring>
using namespace std;

const int SIZE=9;

class Solution {

    int rows[SIZE];
    int cows[SIZE];
    int squares[SIZE];

    void init(){
        memset(rows,0,SIZE*sizeof(int));
        memset(cows,0,SIZE*sizeof(int));
        memset(squares,0,SIZE*sizeof(int));
    }

    bool test(int r,int c,int v){
        return !(rows[r]&(1<<v)) &&
            !(cows[c]&(1<<v)) &&
            !(squares[r/3*3+c/3]&(1<<v));
    }

    void set(int r,int c,int v){
        rows[r]|=(1<<v);
        cows[c]|=(1<<v);
        squares[r/3*3+c/3]|=(1<<v);
    }

public:
    bool isValidSudoku(vector<vector<char> > &board) {
    // bool isValidSudoku(char board[][SIZE+1]) {
        init();
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(board[i][j]=='.'){
                    continue;
                }

                int value=board[i][j]-'1';
                if(!test(i,j,value)){
                    return false;
                }
                set(i,j,value);
            }
        }
        return true;
    }
    
};

// int main(){
//     char board[SIZE][SIZE+1]={
//         ".87654321","2........","3........","4........","5........","6........","7........","8........","9........"
//     };
//     Solution s;
//     cout<<s.isValidSudoku(board);
// }