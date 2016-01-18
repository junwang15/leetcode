public class Celebrity {
    public int findCelebrity(int n) {
    	// find a candidate
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            // every person we skiped cannot be celebrity because there exists someone does not know him
        	if(knows(candidate, i))
        		candidate = i;
        }
        // check if the candidate is a celebrity
        for(int i = 0; i < n; i++) {
        	if(i != candidate &&(knows(candidate, i) || !knows(i, candidate)))
    			return -1;
        }
        return candidate;
    }
}