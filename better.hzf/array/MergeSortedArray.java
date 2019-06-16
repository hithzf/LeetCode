package array;

/**
 * 88. Merge Sorted Array
 * @author hzf
 * ��������������ϲ����ϲ����������Ȼ��������
 * @see https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1, i = m - 1, j = n - 1;
        while(i > -1 && j > -1){
        	if(nums1[i] > nums2[j]){
        		nums1[cur--] = nums1[i--];
        	}else{
        		nums1[cur--] = nums2[j--];
        	}
        }
        while(j > -1){
        	nums1[cur--] = nums2[j--];
        }
    }

	public static void main(String[] args) {
		
	}
}
