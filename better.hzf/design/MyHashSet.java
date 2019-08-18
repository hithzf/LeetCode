package design;

public class MyHashSet {
	
	private byte[] arr;
	
	/** Initialize your data structure here. */
    public MyHashSet() {
    	arr = new byte[1000001];
    }
    
    public void add(int key) {
        arr[key] = (byte)1;
    }
    
    public void remove(int key) {
        arr[key] = (byte)0;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key] == (byte)1;
    }

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		System.out.println(hashSet.contains(1));    // returns true
		System.out.println(hashSet.contains(3));    // returns false (not found)
		hashSet.add(2);          
		System.out.println(hashSet.contains(2));    // returns true
		hashSet.remove(2);          
		System.out.println(hashSet.contains(2));    // returns false (already removed)
	}

}
