package dynamic_programming;

/**
 * 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] flag = new boolean[s.length()][s.length()];
        for(int j = 0; j < s.length(); j++){
            for(int i = 0; i < s.length() - j; i++){
                if(j == 0){
                    flag[i][i] = true;
                }else if(j == 1){
                    flag[i][i+1] = (s.charAt(i+1) == s.charAt(i));
                }else {
                    flag[i][i + j] = flag[i + 1][i + j - 1] && s.charAt(i) == s.charAt(i + j);
                }
            }
        }
        String res = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(flag[i][j] && j - i + 1 > res.length()){
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("cbbddaaddbb"));
    }
}
