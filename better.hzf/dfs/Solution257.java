package dfs;

import tree.SumRootToLeafNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        if(root.left == null && root.right == null){
            res.add(String.valueOf(root.val));
            return res;
        }
        if(root.left != null){
            List<String> leftList = binaryTreePaths(root.left).stream().map(e -> (root.val + "->" + e)).collect(Collectors.toList());
            res.addAll(leftList);
        }
        if(root.right != null){
            res.add(root.val + "->" + binaryTreePaths(root.right));
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
