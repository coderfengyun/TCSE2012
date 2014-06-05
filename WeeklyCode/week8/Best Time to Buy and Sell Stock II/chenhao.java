import java.util.Objects;

public class Solution {
    public int maxProfit(int[] prices) {
        prices=Objects.requireNonNull(prices,"input prices array must not be null");
        int sumOfProfit=0;
        for(int i=1;i<prices.length;i++){
            sumOfProfit+=Math.max(0,prices[i]-prices[i-1]);
        }
        return sumOfProfit;
    }
}