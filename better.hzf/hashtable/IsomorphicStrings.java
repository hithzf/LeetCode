package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * 给定两个字符串，判断是否异构的（异构的含义是维护一套字母的映射关系，对s进行映射后可转换成t）
 * @author hzf
 * @see https://leetcode.com/problems/isomorphic-strings/
 * TODU:这题容易做错
 */
public class IsomorphicStrings {
	
    public boolean isIsomorphic(String s, String t) {
    	if(s == null || t == null || s.length() != t.length()){
        	return false;
        }
        Map<Character, Character> map = new HashMap<>();
		for (int i = 0, len = s.length(); i < len; i++) {
			if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
				map.put(s.charAt(i), t.charAt(i));
			} else {
				if (map.get(s.charAt(i)) != null && map.get(s.charAt(i)) != t.charAt(i)) {
					return false;
				} else if (map.get(s.charAt(i)) != null && map.get(s.charAt(i)) == t.charAt(i)) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
    }

	public static void main(String[] args) {
		IsomorphicStrings ins = new IsomorphicStrings();
		System.out.println(ins.isIsomorphic("aab", "aaa"));
	}

}
