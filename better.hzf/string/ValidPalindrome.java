package string;

/**
 * 125. Valid Palindrome
 * 判断一个字符串是否是回文串，忽略除了字母和数字以外的字符
 * @author hzf
 * @see https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
	
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
        	return true;
        }
        s = s.toLowerCase();
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
        	//TODO:一定要注意数组越界的问题
        	while(i < s.length() && !isAlphanumeric(s.charAt(i))){
        		i++;
        	}
        	while(j > -1 && !isAlphanumeric(s.charAt(j))){
        		j--;
        	}
        	if(i >= j){
        		break;
        	}
        	if(s.charAt(i) == s.charAt(j)){
        		continue;
        	}else{
        		return false;
        	}
        }
        return true;
    }

    /**
     * 一个字符是否是字母或数字
     * @param ch
     * @return
     */
	private boolean isAlphanumeric(char ch) {
		if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ValidPalindrome ins = new ValidPalindrome();
		System.out.println(ins.isPalindrome("1a2"));
	}

}
