package design;

import java.util.Stack;

/**
 * 155. Min Stack
 * @author hzf
 * @see https://leetcode.com/problems/min-stack/
 */
public class MinStack {
	
	private Stack<Integer> value;
	private Stack<Integer> min;
	
	/** initialize your data structure here. */
    public MinStack() {
        value = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(!min.empty() && min.peek() < x){
        	min.push(min.peek());
        }else{
        	min.push(x);
        }
        value.push(x);
    }
    
    public void pop() {
        value.pop();
        min.pop();
    }
    
    public int top() {
        return value.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-1);
		System.out.println(minStack.getMin());   //--> Returns -3.
		System.out.println(minStack.top());      //--> Returns 0.
		minStack.pop();
		System.out.println(minStack.getMin());   //--> Returns -2.
	}

}
