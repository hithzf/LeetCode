package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40.组合总数II
 * @author hzf
 * @see https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
	
	private List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtracking(candidates, track, target, 0, 0);
        return res;
    }
	
	private void backtracking(int[] candidates, LinkedList<Integer> track, int target, int trackSum, int startIndex) {
		if(trackSum == target){
			res.add(new LinkedList(track));
			return;
		}
		if(trackSum > target){
			return;
		}
		
		for(int i = startIndex; i < candidates.length; i++){
			if(i-1 >= startIndex && candidates[i] == candidates[i-1]){
				continue;
			}
			track.add(candidates[i]);
			backtracking(candidates, track, target, trackSum + candidates[i], i+1);
			track.removeLast();
		}
	}

	public static void main(String[] args) {
		int[] candidates = {2,5,2};
		System.out.println(new CombinationSumII().combinationSum2(candidates, 0));
	}

}
