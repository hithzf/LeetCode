package double_pointer;

/**
 * 80.Remove Duplicates From Sorted Array II
 * @see https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int shift = 0;
        int i = 0;
        while(i < nums.length){

            int j = i;
            while(j < nums.length && nums[j] == nums[i]){
                nums[j-shift] = nums[j];
                j++;
            }

            if(j - i - 2 > -1){
                shift += (j - i - 2);
            }
            i = j;
        }
        return nums.length - shift;
    }
}
