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

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null || s.length() != t.length())
            return false;
            
        int[] mapS = new int[26];
        int[] mapT = new int[26];
        for(int i = 0; i < s.length(); i++) {
            mapS[s.charAt(i) - 'a']++;
            mapT[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(mapS[i] != mapT[i])
                return false;
        }
        return true;
    }
}
