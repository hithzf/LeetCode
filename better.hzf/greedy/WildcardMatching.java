package greedy;

/**
 * 44. Wildcard Matching
 * @author hzf
 * TODO: NOT SOLVE
 */
public class WildcardMatching {
	
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        while(i < s.length() && j < p.length()){
        	if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)){
        		i++;j++;
        	}else if(p.charAt(j) == '*'){
        		boolean res = false;
        		int[] tempResult = findNextCharIndex(p, j+1);
        		int nextCharIndex = tempResult[0];
        		if(nextCharIndex == -1){
        			if(i-1+tempResult[1] < s.length()){
        				return true;
        			}else{
        				return false;
        			}
        		}
	        	int nextIndex = s.indexOf(p.charAt(nextCharIndex), i+tempResult[1]);
	        	while(nextIndex != -1){
	        		res = res || isMatch(s.substring(nextIndex + 1), p.substring(nextCharIndex + 1));
	        		if(res){
	        			return true;
	        		}
	        		nextIndex = s.indexOf(p.charAt(nextCharIndex), nextIndex + 1);
	        	}
	        	return res;
        	}else{
        		return false;
        	}
        }
        //ÉÆºó´¦Àí
        if(i < s.length()){
        	return false;
        }else if(j < p.length()){
        	while(j < p.length()){
        		if(p.charAt(j) != '*'){
        			return false;
        		}
        		j++;
        	}
        }
        return true;
    }
    
    private int[] findNextCharIndex(String p, int j) {
    	int[] res = new int[2];
    	int count = 0;
		while(j < p.length()){
			if(p.charAt(j) == '?'){
				count++;
			}else if(p.charAt(j) != '*' && p.charAt(j) != '?'){
				res[0] = j; res[1] = count;
				return res;
			}
			j++;
		}
		res[0] = -1; res[1] = count;
		return res;
	}

	public static void main(String[] args) {
		WildcardMatching solution = new WildcardMatching();
		System.out.println(solution.isMatch("c", "*?*"));
	}

}
