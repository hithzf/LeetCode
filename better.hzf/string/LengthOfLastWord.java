package string;

/**
 * 58. Length of Last Word
 * 给出一个字符串中最后一个单词的长度
 * @author hzf
 * @see https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if(s == null){
			return 0;
		}
        s = s.trim();
        int lastIndexOfSpace = s.lastIndexOf(" ");
        if(lastIndexOfSpace == -1){
        	return s.length();
        }
        return s.length() - 1 - lastIndexOfSpace;
    }
}
