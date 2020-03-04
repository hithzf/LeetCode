package greedy;

/**
 * 45. Jump Game II
 * @see https://leetcode-cn.com/problems/jump-game-ii/
 * TODO:需要考虑O(n^2)算法的时间复杂度问题
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int step = 0, end = 0, maxPosition = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == end){
                step++;
                end = maxPosition;
            }
        }
        return step;
    }
}
