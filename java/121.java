/**
 * Say you have an array for which the ith element is the price of a given stock on day i. 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one
 *  share of the stock), design an algorithm to find the maximum profit.
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
        	return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
        	if(prices[i] > prices[i-1])
        		maxProfit = Math.max(maxProfit, prices[i]-minPrice);
        	else
        		minPrice = Math.min(minPrice, prices[i]);
        	System.out.println(maxProfit);
        }
        return maxProfit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,3,1,4,5,6,3};
		System.out.println(maxProfit(prices));
	}

}
