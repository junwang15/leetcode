
public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
        if(coins == null || amount < 0)
        	return -1;
        int[] dp = new int[amount + 1];      
        for(int i = 1; i < amount + 1; i++) {
        	int min = Integer.MAX_VALUE;
        	for(int j = 0; j < coins.length; j++) {
        		if(i >= coins[j] && dp[i-coins[j]] != -1)
        			min = Math.min(min, dp[i-coins[j]] + 1);
        	}
        	dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,5};
		System.out.println(coinChange(coins, 1));
		System.out.println(coinChange(coins, 2));
		System.out.println(coinChange(coins, 3));
		System.out.println(coinChange(coins, 11));
	}

}
