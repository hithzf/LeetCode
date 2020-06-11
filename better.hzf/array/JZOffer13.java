package array;

import java.util.LinkedList;
import java.util.Queue;

public class JZOffer13 {

    public int movingCount(int m, int n, int k) {
        int res = 0;
        int[] sum = new int[Math.max(m, n) + 1];
        for(int i = 0; i < sum.length; i++){
            sum[i] = calBitSum(i);
        }

        boolean[][] flag = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(sum[cur[0]] + sum[cur[1]] <= k && !flag[cur[0]][cur[1]]){
                flag[cur[0]][cur[1]] = true;
                if(cur[0] - 1 > -1) {
                    queue.add(new int[]{cur[0] - 1, cur[1]});
                }
                if(cur[1] - 1 > -1){
                    queue.add(new int[]{cur[0], cur[1] - 1});
                }
                if(cur[0] + 1 < m){
                    queue.add(new int[]{cur[0] + 1, cur[1]});
                }
                if(cur[1] + 1 < n){
                    queue.add(new int[]{cur[0], cur[1] + 1});
                }
                res++;
            }
        }
        return res;
    }

    private int calBitSum(int x){
        int sum = 0;
        while(x > 0){
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        JZOffer13 solution = new JZOffer13();
        System.out.println(solution.movingCount(16, 16, 4));
    }
}
