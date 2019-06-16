package dynamic_programming;

/**
 * 72. Edit Distance
 * 给定两个字符串1和2，将1转换成2的最小操作步骤是多少（只允许三种操作：插入一个字符，删除一个字符，替换一个字符）
 * @author hzf
 * @see https://leetcode.com/problems/edit-distance/submissions/
 */
public class EditDistance {
	
	public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if(n == 0 || m == 0){
        	return Math.max(m, n);
        }
        int[][] dp = new int[m][n];
        for(int i = m-1; i > -1; i--){
        	for(int j = n-1; j > -1; j--){
        		if(i == m-1 && j == n-1){
        			if(word1.charAt(i) == word2.charAt(j)){
        				dp[i][j] = 0;
        			}else{
        				dp[i][j] = 1;
        			}
        		}else{
        			int dp_i1_j = i + 1 < m ? dp[i+1][j] : (n - j);
        			int dp_i_j1 = j + 1 < n ? dp[i][j+1] : (m - i);
        			int dp_i1_j1 = (i + 1 < m && j + 1 < n) ? dp[i+1][j+1] : Math.max(m-(i+1), n-(j+1));
        			if(word1.charAt(i) == word2.charAt(j)){
        				dp[i][j] = Math.min(Math.min(dp_i1_j1, dp_i1_j + 1), dp_i_j1 + 1);
        			}else{
        				dp[i][j] = Math.min(Math.min(dp_i1_j1 + 1, dp_i1_j + 1), dp_i_j1 + 1);
        			}
        		}
        	}
        }
        return dp[0][0];
    }

	public static void main(String[] args) {
		String word1 = "", word2 = "";
		EditDistance ins = new EditDistance();
		System.out.println(ins.minDistance(word1, word2));
	}

}
