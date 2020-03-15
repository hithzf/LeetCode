package string;

import java.util.LinkedList;

/**
 *
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        String[] nameArray = path.split("/");
        for(String name : nameArray){
            if(name.equals(".") || name.equals("")){

            }else if(name.equals("..")){
                if(!stack.isEmpty()) {
                    stack.removeLast();
                }
            }else{
                stack.addLast(name);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append("/").append(stack.removeFirst());
        }
        return result.toString().equals("") ? "/" : result.toString();
    }

    public static void main(String[] args){
        SimplifyPath solution = new SimplifyPath();
        System.out.println(solution.simplifyPath("/../"));
    }
}
