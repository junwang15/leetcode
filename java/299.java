/** 
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
 */

public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] sArray = new int[10]; // these two arrays are used to count the times each digit appears (excluding bull digits)
        int[] gArray = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s == g) {
                bull++;
            } else {
                sArray[s]++;
                gArray[g]++;
            }
        }
        for(int j = 0; j < 10; j++)
            cow += Math.min(sArray[j], gArray[j]);
        return String.format("%dA%dB", bull, cow);
    }
}
