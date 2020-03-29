package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 99. Recover Binary Search Tree
 */
public class RecoverBinarySearchTree {

    private LinkedList<TreeNode> list = new LinkedList<>();

    private TreeNode wrong = null;
    private boolean flag = false;

    public void recoverTree(TreeNode root) {
        retrieve(root);
        if(!flag){
            swap(wrong, list.getLast());
        }
    }

    public void retrieve(TreeNode root){
        if(root == null || flag){
            return;
        }
        if(root.left == null && root.right == null){
            findResult(root);
            list.add(root);
            return;
        }
        retrieve(root.left);
        findResult(root);
        list.add(root);
        retrieve(root.right);
    }

    public void findResult(TreeNode root){
        if(!flag && wrong != null && wrong.val < root.val){
            swap(wrong, list.getLast());
            flag = true;
            return;
        }
        if(wrong == null && !list.isEmpty() && root.val < list.getLast().val){
            wrong = list.getLast();
        }
    }

    public void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
