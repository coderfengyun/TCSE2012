class Solution {
public:
    void combineSub(vector<vector<int> > &results, vector<int> &base, int iStart, int n, int k){
        if(k == 1){
            for(int i = iStart; i <= n; i++){
                base.push_back(i);
                results.push_back(base);
                base.pop_back();
            }
            return;
        }else if(iStart+k-1 == n){
            for(int i = iStart; i <= n; i++){base.push_back(i);}
            results.push_back(base);
            base.erase(base.end()-k, base.end());
            return;
        }else{
            for(int i = iStart; i <= n-k+1; i++){
                base.push_back(i);
                combineSub(results, base, i+1, n, k-1);
                base.pop_back();
            }
            return;
        }
    }

    vector<vector<int> > combine(int n, int k) {
        vector<vector<int> > results;
        if(k <= 0 || n <= 0) return results;
        
        vector<int> base;
        combineSub(results, base, 1, n, k);
        return results;
    }
};
