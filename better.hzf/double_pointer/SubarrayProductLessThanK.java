package double_pointer;

/**
 * 713. Subarray Product Less Than K
 * @author hzf
 * @see https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * TODO: 时间复杂度为O(n)的解法
 */
public class SubarrayProductLessThanK {
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
		int count = 0;
		int temp = 1, i = 0;
		for (int j = 0; j < nums.length; j++) {
			temp *= nums[j];
			while (temp >= k) {
				temp /= nums[i++];
			}
			count += (j - i + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {2, 1, 3};
		SubarrayProductLessThanK solution = new SubarrayProductLessThanK();
		System.out.println(solution.numSubarrayProductLessThanK(nums, 2));
	}

}
