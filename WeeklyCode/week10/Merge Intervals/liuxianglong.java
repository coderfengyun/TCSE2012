class liuxianglong {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if(intervals.size()==0) return res;
        Comparator<Interval> comp = new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                return i1.start-i2.start;
            }  
        };
        Collections.sort(intervals,comp);
        Interval cur = intervals.get(0);
        Interval last = new Interval(cur.start,cur.end);
        res.add(last);
        for(int i=1;i<intervals.size();i++){
            cur = intervals.get(i);
            if(cur.end>last.end){
                if(cur.start>last.end){
                    last = new Interval(cur.start,cur.end);
                    res.add(last);
                }else{
                    last.end = cur.end;
                }
            }
        }
        return res;
    }
}