package hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * ÖÐÐò±éÀú
 * @author hzf
 * @see https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root != null){
        	myInOrder(root, res);
        }
        return res;
    }
	
	private void myInOrder(TreeNode root, List<Integer> res) {
		if(root.left != null){
			myInOrder(root.left, res);
		}
		res.add(root.val);
		if(root.right != null){
			myInOrder(root.right, res);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
