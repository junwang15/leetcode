/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null)
            return false;
        String[] string = str.split(" ");
        if(pattern.length() != string.length)
            return false;
        Map<Character, String> map = new HashMap<Character, String>();
        for(int i = 0; i < string.length; i++) {
            char c = pattern.charAt(i);
            if(!map.containsKey(c))
                map.put(c, string[i]);
            else if(!map.get(c).equals(string[i]))
                return false;
        }
        Map<String, Character> map2 = new HashMap<String, Character>();
        for(int i = 0; i < string.length; i++) {
            String s = string[i];
            if(!map2.containsKey(s))
                map2.put(s, pattern.charAt(i));
            else if(!map2.get(s).equals(pattern.charAt(i)))
                return false;
        }
        return true;
    }
}
