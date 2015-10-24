/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum 
 * length of S is 1000, and there exists one unique longest palindromic substring.
 * @author Jun
 *
 */

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
