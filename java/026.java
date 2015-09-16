public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 2) return A.length;
        int count = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] != A[i-1])
                A[count++] = A[i];
        }
        return count;
    }
}

// solution 2 (more efficient)
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 2)    return A.length;
        int count = 0;
        for(int i = 1; i < A.length; i++)
            if(A[count] != A[i])
                A[++count] = A[i];
        return count + 1;
    }
}
