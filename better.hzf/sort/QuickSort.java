package sort;

import java.util.Arrays;

/**
 * 快排变形
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class QuickSort {

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0){
            return new int[0];
        }else if(k >= arr.length){
            return arr;
        }
        quick(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    public void quick(int[] arr, int low, int high, int k){
        int p = partition(arr, low, high);
        if(p == k){
            return;
        }else if(k < p){
            quick(arr, low, p-1, k);
        }else{
            quick(arr, p+1, high, k);
        }
    }

    public int partition(int[] arr, int low, int high){
        int target = arr[low];
        int i = low, j = high+1;
        while(true){
            while(arr[++i] < target){
                if(i == high){
                    break;
                }
            }
            while(arr[--j] > target){
                if(j == low){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        QuickSort quickSort = new QuickSort();
        int[] arr = {0,0,2,3,2,1,1,2,0,4};
        int[] res = quickSort.getLeastNumbers(arr, 10);
        System.out.println(Arrays.toString(res));
    }
}
