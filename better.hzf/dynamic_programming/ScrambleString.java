package dynamic_programming;

/**
 * 87. Scramble String
 * TODO:没有想到
 */
public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()){
            return false;
        }
        if(equalsOrReverse(s1, s2)){
            return true;
        }
        int[] letters = new int[26];
        for(int i = 0; i < s1.length(); i++){
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < letters.length; i++){
            if(letters[i] != 0){
                return false;
            }
        }
        for(int i = 1; i < s1.length(); i++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
                return true;
            }
            if(isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))){
                return true;
            }
        }
        return false;
    }

    public boolean equalsOrReverse(String str1, String str2){
        if(str1.equals(str2)){
            return true;
        }
        StringBuilder sb1 = new StringBuilder(str1);
        return sb1.reverse().toString().equals(str2);
    }

    public static void main(String[] args){
        ScrambleString solution = new ScrambleString();
        System.out.println(solution.isScramble("abcdeabcde",
                "caebdabcde"));
    }
}
