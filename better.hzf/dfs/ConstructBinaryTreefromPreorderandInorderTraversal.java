package dfs;

import java.util.Arrays;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * @author hzf
 * @see https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0){
			return null;
		}
        TreeNode root = new TreeNode(preorder[0]);
        int index = findIndex(inorder, preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1+index), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1+index, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));
        return root;
    }
	
	private int findIndex(int[] inorder, int val) {
		for(int i = 0; i < inorder.length; i++){
			if(inorder[i] == val){
				return i;
			}
		}
		return -1;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
