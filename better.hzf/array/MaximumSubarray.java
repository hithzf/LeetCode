package array;


/**
 * 53. Maximum Subarray
 * ����һ�����飬�ҵ�һ�������飬ʹ���������Ԫ�صĺ����
 * @author hzf
 * @see https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
	
	/**
	 * solutions from others
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
        int maxEndingHere = nums[0],maxSoFar = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxEndingHere = Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar = Math.max(maxSoFar,maxEndingHere);
        }
        return maxSoFar;
    }

	public static void main(String[] args) {
		MaximumSubarray max = new MaximumSubarray();
		int[] testArray = {};
		System.out.println(max.maxSubArray(testArray));
	}

}
