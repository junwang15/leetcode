public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows < 2 || numRows >= len)   return s;

        StringBuffer solution = new StringBuffer(len);
        for (int line = 0; line < numRows; line++) {
            int i = 2*(numRows - line -1);
            int j = 2*line;
            int count = line;
            solution.append(s.charAt(count));
            while (count < len) {
                count += i;
                if (i > 0 && count < len)  solution.append(s.charAt(count));
                count += j;
                if (j > 0 && count < len)  solution.append(s.charAt(count));
            }
        }
        return solution.toString();
    }
}
