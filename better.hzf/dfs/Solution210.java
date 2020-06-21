package dfs;

import java.util.*;

class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> nextMap = new HashMap();

        for(int[] order : prerequisites){
            if(inDegree.containsKey(order[0])){
                inDegree.put(order[0], inDegree.get(order[0]) + 1);
            }else{
                inDegree.put(order[0], 1);
            }

            if(nextMap.containsKey(order[1])){
                nextMap.get(order[1]).add(order[0]);
            }else{
                Set<Integer> set = new HashSet();
                set.add(order[0]);
                nextMap.put(order[1], set);
            }
        }

        if(inDegree.size() == numCourses){
            return new int[]{};
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(!inDegree.containsKey(i)){
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res[index++] = cur;
            Set<Integer> next = nextMap.get(cur);
            if(next != null) {
                for (Integer ele : next) {
                    inDegree.put(ele, inDegree.get(ele) - 1);
                    if (inDegree.get(ele) == 0) {
                        queue.add(ele);
                    }
                }
            }
        }

        if(index != numCourses){
            return new int[]{};
        }

        return res;
    }

    public static void main(String[] args){
        int[][] arr = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(new Solution210().findOrder(4, arr)));
    }
}
