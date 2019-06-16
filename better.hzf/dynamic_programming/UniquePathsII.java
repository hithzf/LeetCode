package dynamic_programming;

/**
 * 63. Unique Paths II
 * m x n的矩阵中可能有障碍物，从左上方走到右下方有多少种走法，一次只能向右和向下移动一格
 * @author hzf
 * @see https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid.length == 0){
            return 0;
        }
    	int m = obstacleGrid.length, n = obstacleGrid[0].length;
    	int[][] dp = new int[m][n];
    	for(int i = m-1; i > -1; i--){
    		for(int j = n-1; j > -1; j--){
    			if(i == m-1 && j == n-1){
    				if(obstacleGrid[i][j] == 1){
    					return 0;
    				}
    				dp[i][j] = 1;
    			}else{
    				if(obstacleGrid[i][j] == 1){
    					dp[i][j] = 0;
    				}else{
    					int right = j+1<n ? dp[i][j+1] : 0;
    					int down = i+1<m ? dp[i+1][j] : 0;
    					dp[i][j] = right + down;
    				}
    			}
    		}
    	}
        return dp[0][0];
    }

	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,0,0,0},{1,1,1,1},{0,0,0,1}};
		UniquePathsII un = new UniquePathsII();
		System.out.println(un.uniquePathsWithObstacles(obstacleGrid));
	}

}
