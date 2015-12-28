/**
 * You are playing the following Nim Game with your friend: 
 * There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who 
 * removes the last stone will be the winner. You will take the first turn to remove the stones. Both of you 
 * are very clever and have optimal strategies for the game. Write a function to determine whether you can win
 *  the game given the number of stones in the heap.
 *  For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stone 
 *  you remove, the last stone will always be removed by your friend.
 * @author jun
 *
 */

public class Solution {
	public boolean canWinNim(int n) {
        return n%4 != 0;
    }

	// Runtime Error Message: Line 3: java.lang.OutOfMemoryError: Java heap space
	// Last executed input: 1348820612
    public boolean canWinNim2(int n) {
        boolean[] canWin = new boolean[n+1];
        if(n < 4) return true;
        canWin[1] = canWin[2] = canWin[3] = true;
        for(int i = 4; i <= n; i++)
            if(!canWin[i-1] || !canWin[i-2] || !canWin[i-3])
                canWin[i] = true;
        return canWin[n];
    }
}
