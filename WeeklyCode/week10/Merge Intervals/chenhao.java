public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res=new ArrayList<>();
        if(intervals.isEmpty()){
            return res;
        }
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval i1,Interval i2){
                return i1.start-i2.start;
            }
        });
        
        int curStart=intervals.get(0).start;
        int curEnd=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            Interval itv=intervals.get(i);
            if(itv.start>curEnd){
                res.add(new Interval(curStart,curEnd));
                curStart=itv.start;
                curEnd=itv.end;
            }
            else{
                curEnd=Math.max(curEnd,itv.end);
            }
        }
        res.add(new Interval(curStart,curEnd));
        return res;
    }
}