package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. Permutation Sequence
 * @see https://leetcode-cn.com/problems/permutation-sequence/
 * todo:不需要完全回溯，只需要找到正确的分支进入即可（这也是一种剪枝手段）
 */
public class PermutationSequence {

    private int[] fact;

    public String getPermutation(int n, int k) {
        fact = new int[n+1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++){
            fact[i] = fact[i-1] * i;
        }

        StringBuilder track = new StringBuilder();
        boolean[] visited = new boolean[n+1];
        backtracking(track, n, k, visited);
        return track.toString();
    }

    private void backtracking(StringBuilder track, int n, int k, boolean[] visited){
        if(track.length() == n){
            return;
        }

        int count = fact[n-1-track.length()];
        for(int i = 1; i <= n; i++){
            if(visited[i]){
                continue;
            }
            if(k > count){
                k -= count;
                continue;
            }
            track.append(i);
            visited[i] = true;
            backtracking(track, n, k, visited);
        }
    }

    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();
        System.out.print(solution.getPermutation(4, 9));//182653974
    }
}
