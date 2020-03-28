package dynamic_programming;

/**
 * 44. Wildcard Matching
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if(p.length() == 0){
            return s.length() == 0;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        int m = 1;
        while (m <= p.length() && p.charAt(m-1) == '*'){
            dp[0][m++] = true;
        }
        for(int j = 1; j <= p.length(); j++){
            for(int i = 1; i <= s.length(); i++){
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1) == '*'){
                    for(int k = i; k >= 0; k--){
                        dp[i][j] |= dp[k][j-1];
                        if(dp[i][j]){
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args){
        WildcardMatching solution = new WildcardMatching();
        System.out.println(solution.isMatch("ho",
                "**ho*****"));
    }
}
