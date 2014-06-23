class Solution {
public:

void singleSpiral(const vector<vector<int> > &matrix, vector<int> &result, int lx, int ly, int rx, int ry)
{
    if(matrix.empty() || lx>rx || ly>ry){return;}
    if(lx == rx){
        for(int j = ly; j <= ry; j++)
            result.push_back(matrix[lx][j]);
        return;
    }
    if(ly == ry){
        for(int i = lx; i <= rx; i++)
            result.push_back(matrix[i][ly]);
        return;
    }
    for(int j = ly; j<ry; j++){
        result.push_back(matrix[lx][j]);
    }
    for(int i = lx; i<rx; i++){
        result.push_back(matrix[i][ry]);
    }
    for(int j = ry; j>ly; j--){
        result.push_back(matrix[rx][j]);
    }
    for(int i = rx; i>lx; i--){
        result.push_back(matrix[i][ly]);
    }
}

vector<int> spiralOrder(vector<vector<int> > &matrix) {
    vector<int> result;
    if(matrix.empty() || matrix.front().empty()) return result;

    int m = matrix.size();
    int n = matrix.front().size();
    int pivot = m < n ? m : n;
    int mid = (pivot & 0x0001) != 1 ? ((pivot>>1)-1) : (pivot>>1);
    for(int i = 0 ; i <= mid; i++){
        singleSpiral(matrix,result,i,i,m-1-i,n-1-i);
    }
    return result;
}
};
