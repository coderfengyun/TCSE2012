struct mycmp{
    bool operator () (Interval &ia, Interval &ib)
    {
        if(ia.start != ib.start) return ia.start > ib.start;
        return ia.end > ib.end;
    }
};
class Solution {
public:
    vector<Interval> merge(vector<Interval> &intervals) {
        vector<Interval> ans;
        if(intervals.size() == 0) return ans;
        priority_queue<Interval, vector<Interval>, mycmp> pq;
        for(int i=0; i<intervals.size(); ++i) pq.push(intervals[i]);
        while(pq.size() != 1)
        {
            Interval first = pq.top();
            pq.pop();
            Interval second = pq.top();
            if(second.start > first.end)
                ans.push_back(first);
            else
            {
                pq.pop();
                pq.push(Interval(first.start, max(first.end,second.end)));
            }
        }
        ans.push_back(pq.top());
        return ans;
    }
};