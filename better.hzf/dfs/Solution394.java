package dfs;

import java.util.Stack;

class Solution394 {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int endIndex = findNumEnd(s, i+1);
                numStack.push(Integer.valueOf(s.substring(i, endIndex+1)));
                i = endIndex;
            }else if(s.charAt(i) == '['){
                strStack.push("[");
            }else if(s.charAt(i) == ']'){
                String temp = strStack.pop().substring(1);
                String newStr = buildStr(numStack.pop(), temp);
                if(strStack.isEmpty()){
                    sb.append(newStr);
                }else{
                    strStack.push(strStack.pop() + newStr);
                }
            } else {
                if (strStack.isEmpty()) {
                    sb.append(s.charAt(i));
                } else {
                    strStack.push(strStack.pop() + s.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    private int findNumEnd(String s, int i){
        while(i < s.length()){
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                break;
            }
            i++;
        }
        return i-1;
    }

    private String buildStr(int count, String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++){
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new Solution394().decodeString("2[b3[c4[d]]]"));
    }
}
