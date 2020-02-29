package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
        	int ele = nums[i];
        	if(resultList.isEmpty()){
        		List<Integer> tempList = new ArrayList<>();
        		tempList.add(ele);
        		resultList.add(tempList);
        	}else{
	        	
        	}
        }
        return resultList;
    }

	public static void main(String[] args) {
		Permutations solution = new Permutations();
		int[] nums = {1,2,3};
		System.out.print(solution.permute(nums));
	}

}
