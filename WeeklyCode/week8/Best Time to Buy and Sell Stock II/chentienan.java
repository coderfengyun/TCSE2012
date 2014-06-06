public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, todayPrice = 0;
        if(isPricesNullOrEmpty(prices)) return profit;
        for(int index = 0; index < prices.length - 1; index ++)
        {
            todayPrice = prices[index];
            index = getTheIndexBeginToDecrese(index, prices);
            profit += prices[index] - todayPrice;
        }
        return profit;
    }
    
    private int getTheIndexBeginToDecrese(int indexBegin, int[] prices){
        int result = indexBegin;
        while(result < prices.length - 1 && !isTomorrowPriceLower(result, prices))
        {
            result++;
        }
        return result;
    }

    
    private boolean isPricesNullOrEmpty(int[] prices)
    {
        return prices == null || prices.length ==0;
    }
    
    private boolean isTomorrowPriceLower(int index, int[] prices)
    {
        return prices[index] >= prices[index + 1];
    }
}