/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 **/

public class NumArray {
    private int[] sumArray; // sumArray[i] is the sum from num[0] to num[i-1]
    
    public NumArray(int[] nums) {
        sumArray = new int[nums.length + 1];
        if(nums == null || nums.length == 0)
            return;
        sumArray[0] = 0;
        for(int i = 1; i <= nums.length; i++)
            sumArray[i] = sumArray[i-1] + nums[i-1];
    }

    public int sumRange(int i, int j) {
        if(i > j || i < 0 || j > sumArray.length) 
            return 0;
        return sumArray[j+1] - sumArray[i];
    }

    public static void main(String[] args) {
        int[] anArray = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(anArray);
        System.out.println(na.sumRange(0,1));
        System.out.println(na.sumRange(1,2));
        System.out.println(na.sumRange(1,5));
        System.out.println(na.sumRange(5,5));
    }
}
