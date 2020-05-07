package sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] integerNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            integerNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(integerNums, new Comparator<String>() {
            @Override
            public int compare(String o2, String o1) {
                String s1 = o1 + o2, s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        if(integerNums[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String str : integerNums){
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        int[] nums = {12,121};
        System.out.println(largestNumber(nums));
    }
}
