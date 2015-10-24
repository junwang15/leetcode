/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum 
 * length of S is 1000, and there exists one unique longest palindromic substring.
 * @author Jun
 *
 */
// solution 1 (faster)
public class Solution {
    public String longestPalindrome(String s) {
      if(s == null)  return s;
      int len = s.length();
      String longest = new String();
      for(int i = 0; i < len; i++) {
        if (i+1<len && s.charAt(i) == s.charAt(i+1))
            longest = palindromeSubstring(s, longest, i, i+1);
        longest = palindromeSubstring(s, longest, i, i);
      }
      return longest;
    }
    
    private static String palindromeSubstring(String s, String currentLongest, int start, int end) {
    	while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
        start--; 
        end++;
      }
      start++; 
      if(end-start > currentLongest.length())
        return s.substring(start, end);
      else
      	return currentLongest;
    }
}

// solution 2
public class Solution {
  public String longestPalindrome(String s) {
    int len = s.length();
    String longest = new String();
    boolean[][] dp = new boolean[len][len];
    
    for(int i = len; i >= 0; i--) {
    	for(int j = i; j < len; j++) {
    		dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1]);
        	if(dp[i][j] && ((j-i+1)>longest.length()))
            		longest = s.substring(i, j+1);
    	}
    }
    return longest;
  }
}
