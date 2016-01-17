// Paint house
// DP with constant space complexity

public class Solution {
	public int minCost(int[][] costs) {
		if(cost == null || cost.length == 0 || cost[0].length == 0)
			return -1;
		int n = costs.length;
		int lastR = costs[0][0];
		int lastG = costs[0][1];
		int lastB = costs[0][2];
		for(int i = 1; i < n; i++) {
			curR = Math.min(lastG, lastB) + costs[i][0];
			curG = Math.min(lastR, lastB) + costs[i][1];
			curB = Math.min(lastG, lastR) + costs[i][2];
			lastR = curR;
			lastG = curG;
			lastB = curB;		
		}
		return Math.min(curR, Math.min(curG, curB));
	}
}
