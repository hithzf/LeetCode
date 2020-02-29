package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 78. Subsets
 * @author hzf
 * @see https://leetcode-cn.com/problems/subsets/
 */
public class SubSet {
	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int ele : nums){
        	addElement(res, ele);
        }
        return res;
    }

	private void addElement(List<List<Integer>> res, int ele) {
		if(res.isEmpty()){
			List<Integer> temp = new ArrayList<>();
			temp.add(ele);
			
			res.add(temp);
			res.add(Collections.emptyList());
			return;
		}
		Iterator<List<Integer>> iter = res.iterator();
		List<List<Integer>> temp = new ArrayList<>();
		while(iter.hasNext()){
			List<Integer> list = new ArrayList<>(iter.next());
			list.add(ele);
			
			temp.add(list);
		}
		res.addAll(temp);
	}
	
	public List<List<Integer>> subsetsOthers(int[] nums) {
        
        List<List<Integer>> results = new LinkedList<>();

        // ¿Õ¼¯
        results.add(new LinkedList<>());
        for (int num : nums) {
            results.addAll(results.stream().map(subset -> {
                List<Integer> newSubset = new LinkedList<>(subset);
                newSubset.add(num);

                return newSubset;
            }).collect(Collectors.toList()));
        }

        return results;
        
    }

	public static void main(String[] args) {
		int[] nums = new int[20];
		for(int i = 0; i < nums.length; i++){
			nums[i] = i;
		}
		SubSet subSet = new SubSet();
		List<List<Integer>> res = subSet.subsets(nums);
		System.out.println(res);
	}

}
