package double_pointer;

import java.util.Arrays;

/**
 * 42.½ÓÓêË®
 * @author hzf
 * @see https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class RainWater {
	
	public int trap(int[] height) {
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		
		int curMax = 0;
		for(int i = 0; i < height.length; i++){
			left[i] = (curMax > height[i]) ? curMax : 0;
			curMax = (height[i] > curMax) ? height[i] : curMax;
		}
		curMax = 0;
		for(int i = height.length - 1; i > -1; i--){
			right[i] = (curMax > height[i]) ? curMax : 0;
			curMax = (height[i] > curMax) ? height[i] : curMax;
		}
		
		int trap = 0;
		for(int i = 0; i < height.length; i++){
			int temp = Math.min(left[i], right[i]);
			if(temp > 0){
				trap += (temp - height[i]);
			}
		}
		return trap;
    }

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new RainWater().trap(height));
	}

}
