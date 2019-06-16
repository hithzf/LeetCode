package math;

/**
 * 67. Add Binary
 * 给定两个二进制串，求和
 * @author hzf
 * @see https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if(a == null || b == null){
			return null;
		}
        int len = Math.max(a.length(), b.length());
        StringBuilder builder = new StringBuilder();
        int carry = 0, ai, bi;
        for(int i = 0; i < len; i++){
        	ai = a.length() - 1 - i > -1 ? Integer.parseInt(String.valueOf(a.charAt(a.length() - 1 - i))) : 0;
        	bi = b.length() - 1 - i > -1 ? Integer.parseInt(String.valueOf(b.charAt(b.length() - 1 - i))) : 0;
        	builder.insert(0, (ai + bi + carry) % 2);
        	carry = (ai + bi + carry) / 2;
        }
        if(carry == 1){
        	builder.insert(0, carry);
        }
        return builder.toString();
    }

	public static void main(String[] args) {
		AddBinary ins = new AddBinary();
		System.out.println(ins.addBinary("101", ""));
	}
}
