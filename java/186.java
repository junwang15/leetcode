import java.util.Stack;

/**
 * Reverse Words in a String II
 * Description: Given an input string, reverse the string word by word. A word is defined as a sequence of non-space
 * characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 * Created by jun on 1/21/16.
 */
public class WordString {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0)
            return;
        // reverse the whole sentence
        reverse(s, 0, s.length-1);
        // reverse each word
        for(int i = 0, j = 0; i < s.length; i = j+1) {
            for(j = i+1; j < s.length && s[j] != ' '; j++)
                ;
            reverse(s, i, j-1);
        }
    }

    private void reverse(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++; end--;
        }
    }

    public static void main(String[] args) {
        WordString ws = new WordString();
        char[] s = "what a nice day".toCharArray();
        ws.reverseWords(s);
        System.out.println(s);
    }
}
