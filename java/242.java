/**
 * Given two strings s and t, write a function to determine if t is an anagram of s. 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car", return false.
 * Note: You may assume the string contains only lowercase alphabets.
 * @author Jun
 *
 */

public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
