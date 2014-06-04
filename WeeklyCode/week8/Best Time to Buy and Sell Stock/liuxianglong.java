class liuxianglong {
	public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1) return 0;
        int min = prices[0];int profit=0;
        for(int i=1;i<prices.length;i++){
            int tmp = prices[i]-min;
            if(tmp>profit) profit = tmp;
            if(min>prices[i]) min = prices[i];
        }
        return profit;
    }
}