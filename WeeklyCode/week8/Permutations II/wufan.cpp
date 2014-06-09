class Solution {
public:
    vector<vector<int> > permuteUnique(vector<int> &num) {
        vector<vector<int> > result;
        if (num.size() == 0)
            return result;
        sort(num.begin(), num.end());
        do{
            result.push_back(num);
        }while(nextPermutation(num));
        return result;
    }

   bool nextPermutation(vector<int> &num){
        int i = num.size() - 2;
        // find patition place
        while (i >= 0 && num[i] >= num[i+1]) i--;
        if (i < 0) return false;

        // find the smallest elem that larger than the partition elem
        int j = num.size() - 1;
        while (num[j] <= num[i]) j--;
        swap(num[i], num[j]);
        reverse(num.begin() + i + 1, num.end());

        return true;

    }
};
