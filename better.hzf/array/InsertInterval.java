package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 57. Insert Interval
 * @see //leetcode-cn.com/problems/insert-interval/
 */
public class InsertInterval {

    class Node{
        private int left;
        private int right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
        public int getLeft(){
            return this.left;
        }
        public int getRight(){
            return this.right;
        }
        public void setLeft(int left) {
            this.left = left;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Node> list = new LinkedList<>();
        Node intervalNode = new Node(newInterval[0], newInterval[1]);
        list.add(intervalNode);
        for(int i = 0; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(cur[1] < newInterval[0]){
                list.add(list.size() - 1, new Node(cur[0], cur[1]));
            }else if(cur[0] > newInterval[1]){
                list.add(new Node(cur[0], cur[1]));
            }else if(cur[0] >= newInterval[0] && cur[1] <= newInterval[1]){
                continue;
            }else if(cur[0] <= newInterval[0] && cur[1] >= newInterval[1]){
                intervalNode.setLeft(cur[0]);
                intervalNode.setRight(cur[1]);
            }else if(cur[0] <= newInterval[1] && cur[1] > newInterval[1]){
                intervalNode.setRight(cur[1]);
                newInterval[1] = cur[1];
            }else{
                intervalNode.setLeft(cur[0]);
                newInterval[0] = cur[0];
            }
        }

        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i).getLeft();
            res[i][1] = list.get(i).getRight();
        }
        return res;
    }

    public static void main(String[] args){
        InsertInterval solution = new InsertInterval();
        int[][] arg1 = {{2,6},{10,15},{20,21}};
        int[] arg2 = {21,88};
        int[][] res = solution.insert(arg1, arg2);
    }
}
