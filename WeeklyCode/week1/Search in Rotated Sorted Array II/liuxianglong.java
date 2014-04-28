class liuxianglong {
	public boolean search(int[] A, int target) {
        int left=0;
		int right=A.length-1;
		while(left<=right){
			int mid= (left+right)/2;
			if(A[mid]==target){
				return true;
			}else{
				while(left<mid&&A[left]==A[mid]) left++;
				if(left==mid){
					while(left<=right&&A[left]==A[mid])left++;
				}else{
					if(A[left]>A[mid]){
						if(target<A[left]&&target>A[mid]){
							left = mid +1;
						}else{
							right = mid -1;
						}
					}else{
						if(target>=A[left]&&target<A[mid]){
							right = mid-1;
						}else{
							left = mid+1;
						}
					}
				}
			}
		}
		return false;
    }
}