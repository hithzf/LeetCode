package dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * @author hzf
 * @see https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
	
	public List<List<String>> partition(String s) {
		List<List<String>> res = new LinkedList<List<String>>();
        if(s.length() == 0 || s.length() == 1){
        	List<String> list = new LinkedList<String>();
        	if(s.length() == 1){
        		list.add(s);
        	}
        	res.add(list);
        	return res;
        }
        for(int i = 0; i < s.length(); i++){
        	if(isPalindrome(s.substring(0, i+1))){
        		List<List<String>> tempRes = partition(s.substring(i+1));
        		for(int j = 0; j < tempRes.size(); j++){
        			List<String> list = new LinkedList<String>();
        			list.add(s.substring(0, i+1));
        			list.addAll(tempRes.get(j));
        			res.add(list);
        		}
        	}
        }
        return res;
    }

	private boolean isPalindrome(String str) {
		if(str.length() == 1){
			return true;
		}
		for(int i = 0, j = str.length()-1; i < j; i++, j--){
			if(str.charAt(i) != str.charAt(j)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning solution = new PalindromePartitioning();
		System.out.println(solution.partition("abcbabcba"));
	}

}
