public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i+1);

        for (int j = 0; j < nums.length; j++) {
            Integer idx2 = map.get(target - nums[j]);
            if (idx2 != null && idx2 != j+1)
                return new int[]{j+1, idx2};
        }
        return null;       
    }
}

// solution 2
public class Solution {
    public int[] twoSum(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
	for(int i = 0; i < nums.length; i++) {
		if(map.containsKey(target - nums[i])) 
			return new int[] {map.get(target - nums[i]), i + 1};
			else
				map.put(nums[i], i + 1);
	}
	return null;    
    }
}
