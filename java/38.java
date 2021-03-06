/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 */
public class Solution {
    public String countAndSay(int n) {
        if(n == 0) return "1";
        
        StringBuilder result = new StringBuilder("1");
        for(int i = 1; i < n; i++)
            result = generateNext(result);
        return result.toString();
    }
    
    private StringBuilder generateNext(StringBuilder s) {
        if(s == null || s.length() == 0)    return s;
        StringBuilder next = new StringBuilder();
        for(int i=0; i<s.length();) {
            char c = s.charAt(i);
            int cnt = 0;
            while(i<s.length() && s.charAt(i) == c) {
                cnt++;
                i++;
            }
            next.append(cnt);
            next.append(c);
        }
        return next;
    }
}
