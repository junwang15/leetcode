/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 **/

public class Solution {
    public int climbStairs(int n) {
        int[] step = new int[n+2];  // step should be large enough to contain step[1] and step[2]
        step[1] = 1;
        step[2] = 2;
        for(int i = 3; i <= n; i++)
            step[i] = step[i-1] + step[i-2];
        return step[n];
    }
}
