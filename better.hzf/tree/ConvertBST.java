package tree;

/**
 * 538. Convert BST to Greater Tree
 * @author hzf
 * @see https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class ConvertBST {
	
	private int curSum = 0;
	
	public TreeNode convertBST(TreeNode root) {
		if(root == null){
            return root;
        }
        if(root.right != null){
        	convertBST(root.right);
        }
        root.val += curSum;
        curSum = root.val;
        if(root.left != null){
        	convertBST(root.left);
        }
        return root;
    }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
