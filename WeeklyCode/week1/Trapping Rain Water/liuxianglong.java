class liuxianglong {
	public int trap(int[] A) {
		if(A==null||A.length<3) return 0;
		int capacity= 0;
		int i =0;int j=0;
		int leftMax = A[i];
		int rightMax = A[j];
		while(i<j){
			if(A[i]<A[j]){
				i++;
				if(A[i]<leftMax) {
					capacity+=leftMax-A[i];
				}else{
					leftMax = A[i];
				}
			}else{
				j--;
				if(A[j]<rightMax){
					capacity+=rightMax-A[j];
				}else{
					rightMax=A[j];
				}
			}
		}
        return capacity;
    }
}