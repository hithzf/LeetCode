package tree;

/**
 * 114. Flatten Binary Tree to Linked List
 * @see //leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class BinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        myFlatten(root);
    }

    private TreeNode myFlatten(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode leftLast = myFlatten(root.left);
        TreeNode rightLast = myFlatten(root.right);

        if(leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
        }
        root.left = null;
        return rightLast != null ? rightLast : (leftLast != null ? leftLast : root);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
