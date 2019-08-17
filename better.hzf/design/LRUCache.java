package design;

import java.util.LinkedHashMap;

/**
 * 146. LRU Cache
 * @author hzf
 * @see https://leetcode.com/problems/lru-cache/
 * TODO: you should not use so much time on this problem
 */
public class LRUCache {
	
	private LinkedHashMap<Integer, Integer> cache;
	private int CAPACITY;
	
	public LRUCache(int capacity) {
		CAPACITY = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
    	if(!cache.containsKey(key)){
    		return -1;
    	}else{
    		int value = cache.get(key);
    		cache.remove(key);
    		cache.put(key, value);
    	}
        return cache.get(key);
    }
    
    public void put(int key, int value) {
    	if(cache.containsKey(key)){
    		cache.remove(key);
    		cache.put(key, value);
    		return;
    	}
        if(cache.size() == CAPACITY){
        	int oldKey = cache.entrySet().iterator().next().getKey();
        	cache.remove(oldKey);
        }
        cache.put(key, value);
    }

	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.get(2);
		cache.put(2, 1);
		cache.put(1, 1);    
		cache.put(2, 3);    
		cache.put(4, 1);
		cache.get(1); 
		cache.get(2);
	}

}
