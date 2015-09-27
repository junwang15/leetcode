/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median 
 * of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @author Jun
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int m = nums1.length, n = nums2.length;
    	if((m+n)%2 == 1)
    		return getKth(nums1, nums2, (n+m)/2, 0, m-1, 0, n-1);
    	else
    		return 0.5*(getKth(nums1, nums2, (n+m)/2, 0, m-1, 0, n-1) + getKth(nums1, nums2, (n+m)/2-1, 0, m-1, 0, n-1));
    }
    
    // get the kth element in the union of x and y; k starts from 0
    private double getKth(int[] x, int[] y, int k, int xStart, int xEnd, int yStart, int yEnd) {
    	 int xLength = xEnd - xStart + 1; 
    	 int yLength = yEnd - yStart + 1;
    	 if(xLength == 0)   return y[yStart + k];
    	 if(yLength == 0)   return x[xStart + k];
    	 if(k == 0)         return Math.min(x[xStart], y[yStart]);
    	 
    	 int xMid = xLength * k / (xLength + yLength);
    	 int yMid = k - xMid - 1;
    	 
    	 xMid = xMid + xStart;
    	 yMid = yMid + yStart;
    	 
    	 if(x[xMid] > y[yMid]) {
    		 k = k - (yMid - yStart + 1);
    		 xEnd = xMid;
    		 yStart = yMid + 1;
    	 } else {
    		 k = k - (xMid - xStart + 1);
    		 yEnd = yMid;
    		 xStart = xMid + 1;
    	 }
    	 return getKth(x, y, k, xStart, xEnd, yStart, yEnd);
    }
}
