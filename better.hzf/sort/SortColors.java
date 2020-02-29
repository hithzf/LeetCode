package sort;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * @author hzf
 * @see https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {
	
	public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        int k = 0;
        while(k <= j){
        	if(nums[k] == 0 && k > i){
        		swap(nums, i, k);
        		i++;
        	}else if(nums[k] == 2){
        		swap(nums, k, j);
        		j--;
        	}else{
        		k++;
        	}
        }
        
    }

	private void swap(int[] nums, int i, int k) {
		int temp = nums[i];
		nums[i] = nums[k];
		nums[k] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {1,0, 0,0};
		SortColors ins = new SortColors();
		ins.sortColors(arr);
		System.out.print(Arrays.toString(arr));
	}

}
