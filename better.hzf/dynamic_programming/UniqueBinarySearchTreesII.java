package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * TODO 不应该
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if(n <= 0){
            return new ArrayList<>();
        }
        return gen(1, n);
    }

    private List<TreeNode> gen(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        if(start == end){
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = gen(start, i-1);
            List<TreeNode> right = gen(i+1, end);
            for(TreeNode le : left){
                for(TreeNode ri : right){
                    TreeNode node = new TreeNode(i);
                    node.left = le;
                    node.right = ri;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
