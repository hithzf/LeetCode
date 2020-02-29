package design;

import java.util.HashSet;
import java.util.Set;

/**
 * Trie树有更正确的实现方法 @see https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/
 * @author hzf
 *
 */
class Trie {
	
	private Set<String> searchSet;
	
	private Set<String> startWithSet;

    /** Initialize your data structure here. */
    public Trie() {
        searchSet = new HashSet<String>();
        startWithSet = new HashSet<String>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        searchSet.add(word);
        for(int i = 1; i <= word.length(); i++){
        	startWithSet.add(word.substring(0, i));
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchSet.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startWithSet.contains(prefix);
    }
}
