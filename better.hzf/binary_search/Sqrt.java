package binary_search;

/**
 * 69. Sqrt(x)
 * @author hzf
 * @see https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {

    public int mySqrt(int x) {
    	int before = 0;
        for(int i = 0; i <= x/2+1; i++){
        	if(i * i > x || i * i < before){
        		return i-1;
        	}else if(i * i == x){
        		return i;
        	}
        	before = i * i;
        }
        return 0;
    }
    
    /**
     * TODO:Binary Search Method
     * @param x
     * @return
     */
    public int sqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
    
	public static void main(String[] args) {
		Sqrt sqrt = new Sqrt();
		for(int i = 0; i <= Integer.MAX_VALUE; i++){
			if((int)Math.sqrt(i) != sqrt.mySqrt(i)){
				System.out.println(i);
				System.out.println(Math.sqrt(i));
				System.out.println(sqrt.sqrt(i));
				return;
			}
		}
		System.out.println("end");
	}

}
