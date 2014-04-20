class WeekOne{
public:
    int threeSumClosest(vector<int> &num, int target) {
        sort(num.begin(), num.end());
        int start = 0;
        int end = num.size() - 1;
        int diff = 0;
        int min = INT_MAX;
        int sum = 0;
        int result = 0;
        for (; start < num.size(); start++){
            int i = start+1;
            int j = end;
            while (i < j){
                sum = num[start] + num[i] + num[j];
                diff = abs(sum - target);
                if (diff < min){ 
                    min = diff;
                    result = sum;
                }
                if (sum < target)
                    i++;
                else 
                    j--;
            }
        }
        return result;
    }
};
