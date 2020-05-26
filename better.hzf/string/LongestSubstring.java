package string;

/**
 * 3.无重复最长子串
 */
public class LongestSubstring {

    public static void main(String[] args){
        LongestSubstring solution = new LongestSubstring();
        System.out.println(solution.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int i = 0, j = 1;
        int res = 0;
        while(i < s.length()){
            while(j < s.length() && s.substring(i, j).indexOf("" + s.charAt(j)) == -1){
                j++;
            }
            res = Math.max(res, j - i);
            if(j == s.length()){
                break;
            }
            i = s.substring(0, j).lastIndexOf("" + s.charAt(j)) + 1;
            j = j + 1;
        }
        return res;
    }
}
