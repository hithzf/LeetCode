package binary_search;

import java.util.Arrays;

/**
 * 81. Search in Rotated Sorted Array II
 * @author hzf
 * @see https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {
	
	public boolean search(int[] nums, int target) {
        if(nums.length == 0){
        	return false;
        }
        int start = 0, end = nums.length-1, mid = (start + end) / 2;
        while(start <= end){
        	if(target == nums[mid] || target == nums[start] || target == nums[end]){
        		return true;
        	}
        	if(nums[mid] < nums[end] && (target > nums[end] || target < nums[mid])){
        		start += 1;
        		end = mid - 1;
        	}else if(nums[mid] < nums[end] && target > nums[mid] && target < nums[end]){
        		start = mid + 1;
        		end -= 1;
        	}else if(nums[mid] > nums[end] && target > nums[start] && target < nums[mid]){
        		start += 1;
        		end = mid - 1;
        	}else if(nums[mid] > nums[end] && (target > nums[mid] || target < nums[start])){
        		start = mid + 1;
        		end -= 1;
        	}else if(nums[mid] == nums[end]){
        		//这种情况下，无法判断target在哪边，只能递归处理
        		//case 1：[0,5,6,0,0,0,0]
        		//case 2：[0,0,0,0,5,6,0]
        		boolean res = false;
        		if(start + 1 < mid){
        			int[] half1 = Arrays.copyOfRange(nums, start+1, mid);
        			res = res || search(half1, target);
        		}
        		if(mid + 1 < end){
        			int[] half2 = Arrays.copyOfRange(nums, mid+1, end);
        			res = res || search(half2, target);
        		}
        		return res;
        	}
    		mid = (start + end) / 2;
        }
        return false;
    }

	public static void main(String[] args) {
		SearchInRotatedSortedArrayII solution = new SearchInRotatedSortedArrayII();
		int[] arr = {0,0,0,0,5,6,0};
		System.out.println(solution.search(arr, 6));
	}

}
