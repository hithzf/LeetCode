package dynamic_programming;

/**
 * 62.Unique Paths
 * m x n的矩阵，从左上方走到右下方有多少种走法，一次只能向右和向下移动一格
 * @author hzf
 * @see https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
        int down = m + n - 2;
        int up = Math.min(n - 1, m - 1);
        long res = 1;
        for(int i = 1; i <= up; i++){
            res *= (down - i + 1);
        }
        for(int i = 1; i <= up; i++){
            res /= i;
        }
        return (int)res;
    }
}
