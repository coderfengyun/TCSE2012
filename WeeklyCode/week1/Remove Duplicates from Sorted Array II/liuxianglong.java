class liuxianglong {
	private int backSpace(int duplicate, int threshold){
		if(duplicate <threshold) return 0;
		return duplicate-threshold;
	}
	public int removeDuplicate2(int[] A){
		if(A==null) return 0;
		int length = A.length;
		int threshold = 2;
		if(A.length<=threshold) return length;
		int cur = 1;
		int duplicate=1;
		for(int i=1;i<A.length;i++){
			if(A[i]==A[i-1]){
				duplicate++;
			}else{
				cur -= backSpace(duplicate, threshold);
				duplicate=1;
			}
			A[cur++] = A[i];
		}
		cur -= backSpace(duplicate, threshold);
		return cur;
	}
}