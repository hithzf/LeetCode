package dynamic_programming;

/**
 * 64. Minimum Path Sum
 * m x n的矩阵，从左上方走到右下方的路径长度最小是多少（每个格子中填有非负整数，路径长度等于走过的格子中数字之和），一次只能向右和向下移动一格
 * @author hzf
 * @see https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		if(m == 0){
			return 0;
		}
        int n = grid[0].length;
        if(n == 0){
        	return 0;
        }
        int[][] dp = new int[m][n];
        for(int i = m-1; i > -1; i--){
        	for(int j = n-1; j > -1; j--){
        		if(i == m-1 && j == n-1){
        			dp[i][j] = grid[i][j];
        		}else{
        			int right = j+1 < n ? dp[i][j+1] : Integer.MAX_VALUE;
        			int down = i+1 < m ? dp[i+1][j] : Integer.MAX_VALUE;
        			dp[i][j] = grid[i][j] + Math.min(right, down);
        		}
        	}
        }
        return dp[0][0];
    }

	public static void main(String[] args) {
		MinimumPathSum ins = new MinimumPathSum();
		int[][] grid = {{}};
		System.out.println(ins.minPathSum(grid));
	}

}
