package array;

/**
 * 55. Jump Game
 * @author hzf
 * 给定一个非负数组，有一个小孩站在数组第一个格子处，里面的数字代表小孩能跳的最大格子数，问：小孩是否能跳到最后一个格子
 * @see https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
	
	public boolean canJump(int[] nums) {
		if(nums.length == 0){
			return false;
		}
		if(nums.length == 1){
			return true;
		}
        return myJump(nums, 0);
    }

	private boolean myJump(int[] nums, int start) {
		if(nums[start] >= nums.length-1 - start){
			return true;
		}
		boolean flag = false;
		for(int i = nums[start]; i > 0; i--){
			//快速失败
			if(i != nums[start] && nums[start+i]-nums[start+i+1] <= 1){
				continue;
			}
			flag = flag || myJump(nums, start + i);
			//快速成功
			if(flag){
				return flag;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		JumpGame ins = new JumpGame();
		int[] nums = {3,2,1,0,4};
		long start = System.currentTimeMillis();
		boolean res = ins.canJump(nums);
		long tt = System.currentTimeMillis() - start;
		System.out.println(res + ":*****" + tt);
	}

}
