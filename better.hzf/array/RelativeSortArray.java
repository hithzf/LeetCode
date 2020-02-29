package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class RelativeSortArray {
	
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr1){
            if(map.containsKey(ele)){
                map.put(ele, map.get(ele) + 1);
            }else{
                map.put(ele, 1);
            }
        }

        int cur = 0;
        for(int ele : arr2){
            int freq = map.get(ele);
            for(int i = 0; i < freq; i++){
                arr1[cur++] = ele;
            }
            map.remove(ele);
        }

        Set<Integer> remain = map.keySet();
        List<Integer> list = new ArrayList<>(remain);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
        	for(int j = 0; j < map.get(list.get(i)); j++){
        		arr1[cur++] = list.get(i);
        	}
        }

        return arr1;
    }

	public static void main(String[] args) {
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {};
		RelativeSortArray solution = new RelativeSortArray();
		System.out.println(Arrays.toString(solution.relativeSortArray(arr1, arr2)));
	}

}
