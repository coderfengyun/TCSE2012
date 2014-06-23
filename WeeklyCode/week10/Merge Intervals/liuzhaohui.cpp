/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
struct sort_interval{
    bool operator()(const Interval &left, const Interval &right){
        return left.start < right.start;
    }
};

struct sort_coord{
    bool operator()(const pair<int,char> &lt, const pair<int,char> &rht){
        return lt.first != rht.first ? lt.first < rht.first : lt.second < rht.second;
    }
};

const char cLt = '[';
const char cRht = ']';

vector<Interval> merge(vector<Interval> &intervals) {
    vector<Interval> results;
    if(intervals.empty()) return results;

    sort(intervals.begin(),intervals.end(),sort_interval());

    vector<std::pair<int, char> > coordinate;
    for(int i = 0 ; i < intervals.size(); i++){
        coordinate.push_back(make_pair(intervals[i].start, cLt));
        coordinate.push_back(make_pair(intervals[i].end, cRht));
    }
    sort(coordinate.begin(),coordinate.end(),sort_coord());

    int stk = 0;
    int lt = 0;
    int rht = 0;
    for(int i = 0 ; i < coordinate.size(); i++){
        if(coordinate[i].second == cLt){
            if(stk++ == 0){
                lt = coordinate[i].first;
            }
        }else{
            if(--stk == 0){
                rht = coordinate[i].first;
                results.push_back(Interval(lt,rht));
            }
        }
    }

    return results;
}
};
