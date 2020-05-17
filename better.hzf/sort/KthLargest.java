package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215.第K大的數
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargest {

    public int findKthLargest(int[] nums, int k) {
        if(k < 0 || k > nums.length){
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int ele : nums){
            if(queue.size() < k || ele > queue.peek()){
                queue.add(ele);
            }
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args){
        KthLargest quickSort = new KthLargest();
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int res = quickSort.findKthLargest(arr, 4);
        System.out.println(res);
    }
}
