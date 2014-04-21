class liuxianglong {
	private int twoSumDelta(int[] num, int begin, int end, int target){
		int delta = Integer.MAX_VALUE;
		while(begin<end){
			int sum = num[begin]+num[end];
			if(Math.abs(sum-target)<Math.abs(delta)) {
				delta = sum-target;
				if(delta==0) break;
			}
			if(sum<target){
				begin ++;
			}else{
				end--;
			}
		}
		return delta;
	}
	public int threeSumClosest(int[] num,int target){
		Arrays.sort(num);
		int delta = Integer.MAX_VALUE;
		for(int i =0;i<num.length;i++){
			int tmp = twoSumDelta(num,i+1,num.length-1,target-num[i]);
			if(Math.abs(tmp)<Math.abs(delta)) delta = tmp;
			if(delta==0) return target;
		}
		return target+delta;
	}
}