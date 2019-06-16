package math;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 43. Multiply Strings
 * 两个字符串形式的数字相乘，要求不能用BigInteger进行转换
 * @author hzf
 * @see https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	if(num1.equals("0") || num2.equals("0")){
    		return "0";
    	}
        int[] res = new int[num1.length() + num2.length()];
        for(int i = 0; i < num1.length(); i++){
        	for(int j = 0; j < num2.length(); j++){
        		//now calculate the product of num1[i] * 1...0 and num2[j] * 1...0
        		int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        		int zero = (num1.length() - 1 - i) + (num2.length() - 1 - j);
        		res[zero] += product;
        	}
        }
        //format the array
        for(int i = 0; i < res.length - 1; i++){
        	int temp = res[i];
        	res[i] %= 10;
        	res[i+1] += (temp / 10);
        }
        //output the result
        StringBuilder builder = new StringBuilder();
        for(int i = res.length - 1; i > -1; i--){
        	//to ignore the leading zero
        	if(builder.toString().equals("") && res[i] == 0){
        		continue;
        	}
        	builder.append(res[i]);
        }
        return builder.toString();
    }
    
    public String mathMultiply(String num1, String num2) {
    	BigInteger a = new BigInteger(num1);
    	BigInteger b = new BigInteger(num2);
    	BigInteger res = a.multiply(b);
    	return res.toString();
    }

	public static void main(String[] args) {
		MultiplyStrings ins = new MultiplyStrings();
		System.out.println(ins.multiply("123", "456"));
		System.out.println(ins.mathMultiply("123", "456"));
	}

}
