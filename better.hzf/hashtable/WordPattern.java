package hashtable;

import java.util.HashMap;

/**
 * 290. Word Pattern
 * @author hzf
 * @see https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {
	
    public boolean wordPattern(String pattern, String str) {
        String[] split = str.trim().split(" ");
        if(pattern.length() != split.length){
        	return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
        	if(map.containsKey(pattern.charAt(i))){
        		if(!map.get(pattern.charAt(i)).equals(split[i])){
        			return false;
        		}
        	}else if(map.containsValue(split[i])){
        		return false;
        	}else{
        		map.put(pattern.charAt(i), split[i]);
        	}
        }
        return true;
    }
    
	public static void main(String[] args) {
		WordPattern wordPattern = new WordPattern();
		System.out.println(wordPattern.wordPattern(" ",
				"   "));
	}

}
