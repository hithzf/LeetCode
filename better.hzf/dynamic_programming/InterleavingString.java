package dynamic_programming;

/**
 * 97. Interleaving String
 * @TODO 使用递归超时
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1);
                }else{
                    dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(j-1+i)) || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1 == null || s2 == null || s3 == null){
//            return false;
//        }
//        if(s1.length() + s2.length() != s3.length()){
//            return false;
//        }
//        return myFunc(s1, s2, s3);
//    }
//
//    public boolean myFunc(String s1, String s2, String s3){
//        if(s1.length() == 0){
//            return s2.equals(s3);
//        }
//        if(s2.length() == 0){
//            return s1.equals(s3);
//        }
//        if(s3.charAt(0) != s1.charAt(0) && s3.charAt(0) != s2.charAt(0)){
//            return false;
//        }
//        boolean res = false;
//        if(s3.charAt(0) == s1.charAt(0)){
//            res = myFunc(s1.substring(1), s2, s3.substring(1));
//        }
//        if(s3.charAt(0) == s2.charAt(0)){
//            return res || myFunc(s1, s2.substring(1), s3.substring(1));
//        }
//        return res;
//    }

    public static void main(String[] args){
        InterleavingString solution = new InterleavingString();
        System.out.println(solution.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
