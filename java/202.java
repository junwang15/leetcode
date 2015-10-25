/**
 * Write an algorithm to determine if a number is "happy". A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process 
 * until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers 
 * for which this process ends in 1 are happy numbers. 
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 **/
public class Solution {
  public boolean isHappy(int n) {
    if(n <= 0)  return false;
    int sum = sumSqures(n);
    while(sum/10 > 0)
        sum = sumSqures(sum);
    return sum == 1;
  }
  private int sumSqures(int n) {
    int result = 0;
    do {
        result += Math.pow(n%10, 2);
        n/=10;
    } while(n>0);
    return result;
  }
}
