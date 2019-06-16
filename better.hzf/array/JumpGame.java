package array;

/**
 * 55. Jump Game
 * @author hzf
 * ����һ���Ǹ����飬��һ��С��վ�������һ�����Ӵ�����������ִ���С�������������������ʣ�С���Ƿ����������һ������
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
			//����ʧ��
			if(i != nums[start] && nums[start+i]-nums[start+i+1] <= 1){
				continue;
			}
			flag = flag || myJump(nums, start + i);
			//���ٳɹ�
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
