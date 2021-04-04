public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        int near = (int) Math.pow(2, Math.floor(Math.log(right) / Math.log(2)));
        if (near > left) {
            return 0;
        } else if (near == left) {
            return near;
        } else {
            return near + rangeBitwiseAnd(left - near, right - near);
        }
    }

    public static void main(String[] args) {
        Solution201 solution = new Solution201();
        System.out.println(solution.rangeBitwiseAnd(9, 16));
    }
}
