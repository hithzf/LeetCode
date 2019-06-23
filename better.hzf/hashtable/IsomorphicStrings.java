package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * ���������ַ������ж��Ƿ��칹�ģ��칹�ĺ�����ά��һ����ĸ��ӳ���ϵ����s����ӳ����ת����t��
 * @author hzf
 * @see https://leetcode.com/problems/isomorphic-strings/
 * TODU:������������
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
