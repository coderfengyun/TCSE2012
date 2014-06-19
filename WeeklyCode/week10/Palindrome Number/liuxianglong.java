class liuxianglong {
	public boolean isPalindrome(int x) {
        if(x<0) return false;
        int scale = 1;
        while(x/scale>=10) scale*=10;
        while(x>0){
            int right = x/scale;
            int left = x%10;
            if(right!=left) return false;
            x = x%scale/10;
            scale/=100;
        }
        return true;
    }
}