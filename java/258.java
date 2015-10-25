/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example: Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 **/
 
public class Solution {
    public int addDigits(int num) {
        int result = 0;
        if(num < 10)    return num;
        while(num > 0){
            result += num%10;
            num /= 10;
        }
        return addDigits(result);
    }
}
