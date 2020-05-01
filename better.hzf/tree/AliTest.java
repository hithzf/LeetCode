package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 阿里巴巴笔试题
 * 一个二叉树，打印从左边能看到的第一个节点
 */
public class AliTest {

    public List<Integer> findLeftNodeList(TreeNode root){

        List<Integer> resList = new ArrayList<>();
        if(root == null){
            return resList;
        }

        TreeNode leftNode = root.left, rightNode = root.right;
        resList.add(root.val);
        while(leftNode != null || rightNode != null){
            if(leftNode != null) {
                resList.add(leftNode.val);
            }else{
                resList.add(rightNode.val);
            }
            if(leftNode != null) {
                leftNode = (leftNode.left != null ? leftNode.left : leftNode.right);
            }
            if(rightNode != null) {
                rightNode = (rightNode.left != null ? rightNode.left : rightNode.right);
            }
        }

        return resList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode left2 = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        root.right = left;
        root.left = right;
        left.right = left2;

        AliTest aliTest = new AliTest();
        System.out.println(aliTest.findLeftNodeList(root));
    }
}
