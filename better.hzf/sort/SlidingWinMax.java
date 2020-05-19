package sort;

import java.util.*;

/**
 * 239. Sliding Window Maximum
 * 使用优先队列超时了，改为双端队列
 */
public class SlidingWinMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k > nums.length){
            k = nums.length;
        }
        if(k < 1){
            return new int[0];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            putIntoDeque(queue, nums, i, k);
            queue.add(i);
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = nums[queue.peek()];
        for(int i = k; i < nums.length; i++){

            putIntoDeque(queue, nums, i, k);
            queue.add(i);
            res[i-k+1] = nums[queue.peek()];
        }
        return res;
    }

    private void putIntoDeque(Deque<Integer> queue, int[] nums, int i, int k) {
        if(!queue.isEmpty() && queue.getFirst() == i-k){
            queue.removeFirst();
        }
        while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
            queue.removeLast();
        }
    }

    public static void main(String[] args){
        SlidingWinMax quickSort = new SlidingWinMax();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] res = quickSort.maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
