package math;

/**
 * 50. Pow(x, n)
 *  µœ÷pow(x,n)
 * @author hzf
 * @see https://leetcode.com/problems/powx-n/
 * TODO:not solved completely by self
 */
public class Pow {
	public double myPow(double x, int n) {
		if(n == 0){
			return 1;
		}
		if(n < 0){
			return myPow(1/x, -(n+1)) / x;
		}
		if(n % 2 == 0){
			double temp = myPow(x, n / 2);
			return temp * temp;
		}else{
			double temp = myPow(x, n / 2);
			return temp * temp * x;
		}
    }
	
	public double mathPow(double x, int n) {
		return Math.pow(x, n);
	}

	public static void main(String[] args) {
		Pow pow = new Pow();
		System.out.println(pow.myPow(2.00000,-2147483648));
		System.out.println(pow.mathPow(2.00000,-214748364));
	}

}
