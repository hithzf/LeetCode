package array;

import java.util.Arrays;

class Solution1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int res = -1;
        int left = 1, right = position[position.length - 1] - position[0];
        while (left <= right) {
            int mid = right + (right - left) / 2;
            if (check(mid, position, m)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean check(int x, int[] position, int m) {
        int count = 1, pre = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= x) {
                count++;
                pre = position[i];
            }
        }

        return count >= m;
    }
}
