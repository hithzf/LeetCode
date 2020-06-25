package sort;

import java.util.TreeSet;

public class Solution220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Long ceiling = set.ceiling((long)nums[i] - t);
            if(ceiling != null && ceiling <= (long)nums[i] + t){
                return true;
            }
            set.add((long)nums[i]);
            if(set.size() == k + 1){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(2147483647 + 1);
        System.out.println(new Solution220().containsNearbyAlmostDuplicate(new int[]{0,2147483647},
        1,
        2147483647));
    }
}
