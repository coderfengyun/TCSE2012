class liuxianglong {
	private int transform(int n){
        return n>0?-n:n;
    }
    public int divide(int dividend, int divisor) {
        boolean minus = dividend>0!=divisor>0;
        dividend= transform(dividend);
        divisor= transform(divisor);
        if(dividend>divisor) return 0;
        int res = 0;int bit = 0;
        while((divisor<<bit) >=dividend) {
            bit++;
            if(divisor<<(bit-1)<divisor<<bit) break;//conquer overflow
        }
        while(dividend<=divisor&&bit>0){
            bit--;
            int tmp = divisor<<bit;
            if(dividend<=tmp){
                res+=1<<bit;
                dividend-=tmp;
            }
        }
        return  minus?-res:res;
    }
}