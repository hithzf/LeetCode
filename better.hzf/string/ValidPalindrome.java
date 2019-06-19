package string;

/**
 * 125. Valid Palindrome
 * �ж�һ���ַ����Ƿ��ǻ��Ĵ������Գ�����ĸ������������ַ�
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
        	//TODO:һ��Ҫע������Խ�������
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
     * һ���ַ��Ƿ�����ĸ������
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
