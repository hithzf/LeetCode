package hashtable;

import java.util.HashMap;

/**
 * 219. Contains Duplicate II
 * @author hzf
 * @see https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
        	if(!map.containsKey(nums[i])){
        		map.put(nums[i], i);
        	}else{
        		if(i - map.get(nums[i]) <= k){
        			return true;
        		}else{
        			map.put(nums[i], i);
        		}
        	}
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
