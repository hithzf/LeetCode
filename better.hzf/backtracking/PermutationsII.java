package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. Permutations II
 */
public class PermutationsII {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(track, nums, visited);
        return res;
    }

    private void backtracking(LinkedList<Integer> track, int[] nums, boolean[] visited){
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] || (i-1 > -1 && !visited[i-1] && nums[i-1] == nums[i])){
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backtracking(track, nums, visited);
            track.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();
        int[] nums = {};
        System.out.print(solution.permuteUnique(nums));
    }
}
