package dynamic_programming;

/**
 * 慎用递归，追逐动态规划
 * @see https://leetcode-cn.com/problems/perfect-squares/
 * @author hzf
 *
 */
public class Square {
	
	public int numSquares(int n) {
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++){
			dp[i] = i;
			for(int j = 1; i-j*j >= 0; j++){
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}
		return dp[n];
    }

	public static void main(String[] args) {
		Square square = new Square();
		System.out.println(square.numSquares(7168));
	}

}
