package array;


/**
 * 53. Maximum Subarray
 * 给定一个数组，找到一个子数组，使得子数组各元素的和最大
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
