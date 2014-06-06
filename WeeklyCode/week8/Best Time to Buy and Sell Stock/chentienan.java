public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0 , maxIndex = 0, minIndex = 0, lastMin = 0;
        if(prices == null || prices.length == 0){
            return result;
        }
        for(int i = 0; i < prices.length; i++){
            if(prices[i] > prices[maxIndex]){
                maxIndex = i;
            }else if(prices[i] < prices[minIndex]){
                lastMin = minIndex;
                minIndex = i;
            }
            if(minIndex > maxIndex){
                result = Math.max(result, prices[maxIndex] - prices[lastMin]);
                maxIndex = minIndex;
            }
        }
        return Math.max(result, prices[maxIndex] - prices[minIndex]);
    }
}