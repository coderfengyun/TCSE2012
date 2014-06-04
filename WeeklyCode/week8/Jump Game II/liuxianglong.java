class liuxianglong {
	public int jump(int[] A) {
        if(A==null||A.length==0) return -1;
        int begin=0;int end = 0;int step =0;
        while(end<A.length-1){
            int limit = 0;
            step++;
            for(int i=begin;i<=end;i++){
               if(limit<A[i]+i) limit = A[i]+i; 
            }
            if(limit<=end) return -1;
            begin = end+1;
            end = limit;
        }
        return step;
    }
}