package greedy;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        if (S.length() == 0) {
            return new ArrayList();
        }
        int[] end = new int[26];
        for (int i = 0; i < S.length(); i++) {
            end[S.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int head = 0, tail = 0;
        for (int i = 0; i < S.length(); i++) {
            int cur = S.charAt(i) - 'a';
            tail = Math.max(tail, end[cur]);

            if (i == tail) {
                res.add(tail - head + 1);
                head = tail + 1;
            }
        }
        return res;
    }
}
