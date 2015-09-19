/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Solution {
    public int countPrimes(int n) {
    	if (n < 3) return 0;
    	BitSet flags = new BitSet(n);
        for(int i = 2; i < n; i++)
    	    flags.set(i);
    	for(int i = 2; i * i < n; i++) {
    		if(flags.get(i)) {
    			for(int j = i*i; j < n; j += i)
    				flags.set(j, false);
    		} else
    			continue;
    	}
    	return flags.cardinality();
    }    
}
