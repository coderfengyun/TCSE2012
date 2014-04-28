class liuxianglong {
	public int trap(int[] A) {
		if(A==null||A.length<3) return 0;
		int capacity= 0;
		int[] right = new int[A.length];
		right[A.length-1]=0;
		for(int i =A.length-2;i>=0;i--){
			right[i]=right[i+1]>A[i+1]?right[i+1]:A[i+1];
		}
		int left = A[0];
		for(int i=1;i<A.length-1;i++){
			int height = left>right[i]?right[i]:left;
			if(height>A[i]) capacity+= height-A[i];
			left = left>A[i]?left:A[i];
		}
        return capacity;
    }
}