public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null){
            throw new NullPointerException();
        }
        int max=0;
        int curMin=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            max=Math.max(max,prices[i]-curMin);
            curMin=Math.min(curMin,prices[i]);
        }
        return max;
    }
}