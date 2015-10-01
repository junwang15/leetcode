/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)    return 0;
        int len = s.length();
        int p = len - 1, start = 0, end = 0;
        // get the end of a word
        while(p >= 0 && !Character.isAlphabetic(s.charAt(p)))
            p--;
        if(p < 0) return 0;
        end = p;
        // get the start of a word
        while(p >= 0 && Character.isAlphabetic(s.charAt(p)))
            p--;
        start = p;
        return end - start;
    }
}
